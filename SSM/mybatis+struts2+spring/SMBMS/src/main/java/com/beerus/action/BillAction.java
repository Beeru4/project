package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.Bill;
import com.beerus.entity.User;
import com.beerus.service.BillService;
import com.beerus.service.ProvideService;
import com.beerus.service.impl.BillServiceImpl;
import com.beerus.service.impl.ProvideServiceImpl;
import com.beerus.utils.Result;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @Author Beerus
 * @Description 订单Action
 * @Date 2019/4/23
 **/
@Controller
@Component("billAction")
@Scope("prototype")
public class BillAction extends ActionSupport {

    private String nextPage;//下一个页面
    @Resource(name = "billService")
    private BillService billService;//订单业务类
    @Resource(name = "provideService")
    private ProvideService provideService;//供应商业务类

    private Integer currPageNo = 1; //当前页码
    private Integer queryProviderId;//供应商ID
    private String queryProductName;//商品名称
    private Integer queryIsPayment;//是否付款
    private String billCode;//订单编码
    private Bill bill;//订单
    private Integer billid;//订单ID
    private Integer modify;//标示是否是修改


    /**
     * 查询所有订单
     *
     * @return
     */
    public String list_Bill() throws Exception {
        //得到request对象
        ServletRequest request = ServletActionContext.getRequest();
        //查询所有供应商
        request.setAttribute("providerList", provideService.list_FindProvAll());
        //查询所有订单
        request.setAttribute("billList", billService.list_FindAll(new HashMap<String, Object>() {{
            put("currPageNo", currPageNo);
            put("pageSize", 10);
            put("providerId", queryProviderId);
            put("productName", queryProductName);
            put("isPayment", queryIsPayment);
        }}).getPages());
        this.nextPage = "billlist";
        return SUCCESS;
    }

    /**
     * 跳转之前查询供应商
     *
     * @return
     * @throws Exception
     */
    public String billAddBefore_Bill() throws Exception {
        //?
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        //查询所有供应商 转为JSON
        writer.print(JSON.toJSONString(provideService.list_FindProvAll()));
        writer.close();
        return null;
    }

    /**
     * 检查商品编码是否存在
     *
     * @return
     * @throws Exception
     */
    public String checkCode_Bill() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        if (null != billCode && !"".equals(billCode.trim()))
            //判断编码是否存在
            if (!billService.checkCodeIsExists(billCode)) {
                //不存在
                writer.print(JSON.toJSONString(new Result(1000, "noexists")));
            } else {
                //存在
                writer.print(JSON.toJSONString(new Result(1001, "exists")));
            }
        writer.close();
        return null;
    }

    /**
     * 添加订单
     *
     * @return
     */
    public String add_Bill() throws Exception {
        if (null != bill) {
            //设置订单的创建人
            bill.setCreateBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            //添加订单
            if (billService.save_Bill(bill)) {
                //添加成功
                return list_Bill();
            }
        }
        //添加失败
        this.nextPage = "billadd";
        return ERROR;
    }

    /**
     * 修改订单
     *
     * @return
     * @throws Exception
     */
    public String modify_Bill() throws Exception {
        if (null != bill) {
            //设置修改人
            bill.setModifyBy(((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getId());
            if (billService.billModify(bill)) {
                //修改成功
                return list_Bill();
            }
        }
        //修改失败
        this.nextPage = "billmodify";
        return ERROR;
    }

    /**
     * 删除订单
     *
     * @return
     * @throws Exception
     */
    public String delete_Bill() throws Exception {

        if (null != billid && 0 != billid) {
            PrintWriter writer = ServletActionContext.getResponse().getWriter();
            if (billService.delBill(billid)) {
                writer.print("{\"delResult\":\"true\"}");
                //删除成功
                return null;
            } else {
                //删除失败
                writer.print("{\"delResult\":\"false\"}");
            }
        }
        return ERROR;
    }


    /**
     * 查看订单 2种情况
     *
     * @return
     * @throws Exception
     */
    public String view_Bill() throws Exception {
        if (null != billid && 0 != billid)
            //两种情况
            if (null == modify || 0 == modify) {
                //1. 是查看订单详情
                this.nextPage = "billview";
            } else {
                //2.修改之前先查询
                this.nextPage = "billmodify";
                //查询供应商
            }
        //保存订单信息到request当中
        ServletActionContext.getRequest().setAttribute("bill", billService.billView(billid));
        return SUCCESS;
    }


    public String getNextPage() {
        return nextPage;
    }

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Integer getQueryProviderId() {
        return queryProviderId;
    }

    public void setQueryProviderId(Integer queryProviderId) {
        this.queryProviderId = queryProviderId;
    }

    public String getQueryProductName() {
        return queryProductName;
    }

    public void setQueryProductName(String queryProductName) {
        this.queryProductName = queryProductName;
    }

    public Integer getQueryIsPayment() {
        return queryIsPayment;
    }

    public void setQueryIsPayment(Integer queryIsPayment) {
        this.queryIsPayment = queryIsPayment;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getModify() {
        return modify;
    }

    public void setModify(Integer modify) {
        this.modify = modify;
    }
}
