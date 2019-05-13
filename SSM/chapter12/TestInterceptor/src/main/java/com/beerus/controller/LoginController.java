package com.beerus.controller;

import com.beerus.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Beerus
 * @Description 登入控制器
 * @Date 2019-05-10
 **/
@Controller
public class LoginController {
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/sys/main.html")
    public String main() {
        return "index";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login.html")
    public String login() {
        return "login";

    }
    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/dologin")
    public String doLogin(@ModelAttribute(value = "user") User user, HttpServletRequest request) {
        if (null != user.getUserName() && !"".equals(user.getUserName())) {
            //登录成功 保存用户
            request.getSession().setAttribute("user", user);
            //重定向到首页
            return "redirect:/sys/main.html";
        }
        //输入错误 保存错误信息 转发到登录页面
        request.setAttribute("error", "您未输入账号!");
        return "forward:/login.html";

    }

}
