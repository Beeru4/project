package com.beerus.controller;

import com.beerus.common.Common;
import com.beerus.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author Beerus
 * @Description Public Controller
 * @Date 2019-05-15
 **/
@Controller
public class CommonController {
    /**
     * 主页
     *
     * @return
     */
    @RequestMapping(value = "/main.html")
    public String mainPage() {
        return "index";
    }

    /**
     * 后台登入
     *
     * @return
     */
    @RequestMapping(value = "/backendlogin.html")
    public String backendLoginPage() {
        return "backendlogin";
    }

    /**
     * 开发者登入
     *
     * @return
     */
    @RequestMapping(value = "/devlogin.html")
    public String devLoginPage() {
        return "devlogin";
    }

    /**
     * 首页
     *
     * @param session
     * @return
     */
    @RequestMapping("/sys/index.html")
    public String indexPage(HttpSession session) {
        //标示变量
        Object backend = session.getAttribute(Common.BACKEND);
        //判断是开发者用户还是后台用户
        if (Utils.isNotNull(backend) && Common.BACKEND.equals(backend)) {
            //后台用户
            return "/backend/main";
        }
        //开发者用户
        return "/developer/main";
    }

    /**
     * 退出用户
     *
     * @return
     */
    @RequestMapping(value = "/sys/logout")
    public String logOut(HttpSession session) {
        //移除登入会话
        Object backend = session.getAttribute(Common.BACKEND);
        //判断是后台用户还是开发用户
        if (Utils.isNotNull(backend)) {
            session.removeAttribute(Common.BACKEND);
        } else {
            session.removeAttribute(Common.DEV);
        }
        return Common.REDIRECT + "/main.html";
    }
}
