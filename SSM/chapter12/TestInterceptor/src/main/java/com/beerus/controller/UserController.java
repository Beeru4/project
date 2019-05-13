package com.beerus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author Beerus
 * @Description 用户控制器
 * @Date 2019-05-10
 **/
@Controller
@RequestMapping("/sys/user")
public class UserController {
    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logOut(HttpSession session) {
        //移除用户
        session.removeAttribute("user");
        return "login";
    }
}
