package com.beerus.controller;

import com.beerus.entity.Provider;
import com.beerus.entity.User;
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
 * @Description 供应商控制层
 * @Date 2019/4/24
 **/
@Controller
@RequestMapping(value = "/sys/provider")
public class ProviderController {

    /**
     * 供应商业务层
     */
    @Resource(name = "provideService")
    private ProvideService provideService;


    /**
     * 查询所有供应商
     *
     * @return
     */
    @RequestMapping(value = "/providerList.html")
    public String list_Prov(@RequestParam(value = "currPageNo", required = false, defaultValue = "1") final Integer currPageNo,
                            @RequestParam(value = "queryProCode", required = false) final String proCode,
                            @RequestParam(value = "queryProName", required = false) final String proName, HttpServletRequest request) throws Exception {
        //查询所有供应商
        request.setAttribute("providerList", provideService.list_FindAll(new HashMap<String, Object>(4) {{
            put("currPageNo", currPageNo - 1);
            put("pageSize", 10);
            put("proCode", proCode);
            put("proName", proName);
        }}).getPages());
        //查询条件传回页面
        request.setAttribute("queryProCode", proCode);
        request.setAttribute("queryProName", proName);
        return "providerlist";
    }

    /**
     * 查看供应商
     *
     * @return
     */
    @RequestMapping(value = "/viewProvider/{providerId}")
    public String view_Prov(@PathVariable Integer providerId, HttpServletRequest request) throws Exception {
        if (null != providerId) {
            request.setAttribute("provider", provideService.view(providerId));
        }
        return "providerview";
    }

    /**
     * 添加供应商
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addProvider")
    public String add_Prov(@ModelAttribute Provider provider, HttpSession session) throws Exception {
        if (null != provider) {
            //设置创建ID
            provider.setCreateBy(((User) session.getAttribute("user")).getId());
            if (provideService.save(provider)) {
                //添加成功
                return "redirect:/sys/provider/providerList.html";
            }
        }
        return "forward:provideradd";
    }

    /**
     * 检查供应商编码是否存在
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkCodeProv")
    @ResponseBody
    public Model checkCode_Prov(@RequestParam(value = "proCode", required = false) String proCode, Model model) throws Exception {
        //判断供应商编码是否存在
        if (!provideService.checkProCode(proCode)) {
            //不存在
            model.addAttribute(new Result(1000, "noexists"));
        } else {
            //存在
            model.addAttribute(new Result(1001, "exists"));
        }

        return model;
    }

    /**
     * 删除供应商
     *
     * @return
     */
    @RequestMapping(value = "/delProv")
    @ResponseBody
    public Model del_Prov(@RequestParam(value = "proid", required = false) Integer proid, Model model) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>(1);

        if (null != proid) {
            //执行删除
            if (provideService.delete(proid)) {
                //删除成功
                result.put("delResult", "true");
            } else {
                //删除失败
                result.put("delResult", provideService.count_ByDel(proid));
            }
        }
        model.addAttribute("key", result);
        return model;
    }

    /**
     * 修改之前先查询
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/viewBefore.html")
    public String viewBefore_Prov(@RequestParam(value = "proid", required = false) Integer proid, HttpServletRequest request) throws Exception {
        if (null != proid) {
            request.setAttribute("provider", provideService.view(proid));
        }
        return "providermodify";
    }

    /**
     * 修改供应商
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modifyProv")
    public String modify_Prov(@ModelAttribute Provider provider, HttpSession session) throws Exception {
        if (null != provider) {
            //设置修改人
            provider.setModifyBy(((User) session.getAttribute("user")).getId());
            //修改
            if (provideService.update(provider)) {
                //修改成功
                return "redirect:/sys/provider/providerList.html";
            }
        }
        return "redirect:/sys/provider/viewBefore.html";
    }

}
