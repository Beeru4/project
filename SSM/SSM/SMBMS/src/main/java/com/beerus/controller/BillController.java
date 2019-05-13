package com.beerus.controller;

import com.beerus.entity.Bill;
import com.beerus.entity.User;
import com.beerus.service.BillService;
import com.beerus.service.ProvideService;
import com.beerus.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单控制层
 * @Date 2019/4/23
 **/
@Controller
@RequestMapping(value = "/sys/bill")
public class BillController {

    /**
     * 订单业务类
     */
    @Resource(name = "billService")
    private BillService billService;
    /**
     * 供应商业务类
     */
    @Resource(name = "provideService")
    private ProvideService provideService;


    /**
     * 查询所有订单
     *
     * @return
     */
    @RequestMapping(value = "/billList.html")
    public String list_Bill(@RequestParam(value = "currPageNo", required = false, defaultValue = "1") final Integer currPageNo,
                            @RequestParam(value = "queryProviderId", required = false) final Integer queryProviderId,
                            @RequestParam(value = "queryProductName", required = false) final String queryProductName,
                            @RequestParam(value = "queryIsPayment", required = false) final String queryIsPayment,
                            HttpServletRequest request) throws Exception {
        //查询所有供应商
        request.setAttribute("providerList", provideService.list_FindProvAll());
        //查询所有订单
        request.setAttribute("billList", billService.list_FindAll(new HashMap<String, Object>(4) {{
            put("currPageNo", currPageNo);
            put("pageSize", 10);
            put("providerId", queryProviderId);
            put("productName", queryProductName);
            put("isPayment", queryIsPayment);
        }}).getPages());

        //把查询条件传回页面
        request.setAttribute("queryProductName", queryProductName);
        request.setAttribute("queryProviderId", queryProviderId);
        request.setAttribute("queryIsPayment", queryIsPayment);
        return "billlist";
    }

    /**
     * 跳转之前查询供应商
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/billAddBefore")
    @ResponseBody
    public Model billAddBefore_Bill(Model model) throws Exception {
        //查询所有供应商 转为JSON
        model.addAttribute("providers", provideService.list_FindProvAll());
        return model;
    }

    /**
     * 检查商品编码是否存在
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public Model checkCode_Bill(@RequestParam(value = "billCode", required = false) String billCode, Model model) throws Exception {
        if (null != billCode && !"".equals(billCode.trim())) {
            //判断编码是否存在
            if (!billService.checkCodeIsExists(billCode)) {
                //不存在
                model.addAttribute(new Result(1000, "noexists"));
            } else {
                //存在
                model.addAttribute(new Result(1001, "exists"));
            }
        }
        return model;
    }

    /**
     * 添加订单
     *
     * @return
     */
    @RequestMapping(value = "/addBill")
    public String add_Bill(@ModelAttribute Bill bill, HttpSession session) throws Exception {
        if (null != bill) {
            //设置订单的创建人
            bill.setCreateBy(((User) session.getAttribute("user")).getId());
            //添加订单
            if (billService.save_Bill(bill)) {
                //添加成功
                return "redirect:/sys/bill/billList.html";
            }
        }
        //添加失败
        return "billadd";
    }

    /**
     * 修改订单
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateBill")
    public String modify_Bill(@ModelAttribute Bill bill, HttpSession session) throws Exception {
        if (null != bill) {
            //设置修改人
            bill.setModifyBy(((User) session.getAttribute("user")).getId());
            if (billService.billModify(bill)) {
                //修改成功
                return "redirect:/sys/bill/billList.html";
            }
        }
        //修改失败
        return "billmodify";
    }

    /**
     * 删除订单
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delBill")
    @ResponseBody
    public Model delete_Bill(@RequestParam(value = "billid", required = false) Integer billid, Model model) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>(1);
        if (null != billid && 0 != billid) {
            if (billService.delBill(billid)) {
                //删除成功
                result.put("delResult", "true");
            } else {
                //删除失败
                result.put("delResult", "false");
            }
        }
        return model;
    }


    /**
     * 查看订单 2种情况
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/view/{billid}/{modify}")
    public String view_Bill(@PathVariable Integer billid, @PathVariable Integer modify, HttpServletRequest request) throws Exception {
        if (null != billid && 0 != billid) {
            //保存订单信息到request当中
            request.setAttribute("bill", billService.billView(billid));
            //两种情况
            if (null == modify || 0 == modify) {
                //1. 是查看订单详情
                return "billview";
            } else {
                //2.修改之前先查询
                return "billmodify";
            }
        }
        return "redirect:/sys/bill/billList.html";
    }
}
