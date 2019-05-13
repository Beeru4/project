package com.beerus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Beerus
 * @Description Public Controller
 * @Date 2019-05-10
 **/
@Controller
public class CommonController {

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login.html")
    public String login() { return "login"; }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/sys/index.html")
    public String main() { return "frame"; }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/sys/pwdmodify.html")
    public String pwdmodify() {
        return "pwdmodify";
    }

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping(value = "/sys/adduser.html")
    public String addUser() {
        return "useradd";
    }

    /**
     * 添加供应商
     *
     * @return
     */
    @RequestMapping(value = "/sys/addprovider.html")
    public String addProvider() {
        return "provideradd";
    }

    /**
     * 添加订单
     *
     * @return
     */
    @RequestMapping(value = "/sys/addbill.html")
    public String addBill() {
        return "billadd";
    }

    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "/sys/roleadd.html")
    public String addRole() {
        return "roleadd";
    }
}
