package com.beerus.controller;

import com.beerus.entity.User;
import com.beerus.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author Beerus
 * @Description 登录控制层
 * @Date 2019-05-10
 **/
@Controller
@RequestMapping(value = "/sys/login")
public class LoginController {


    @Resource(name = "userService")
    /**用户业务层*/
    private UserService userService;

    /**
     * 用户登录
     *
     * @param userCode     用户编码
     * @param userPassword 用户密码
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "userCode", required = false) String userCode,
                          @RequestParam(value = "userPassword", required = false) String userPassword, HttpServletRequest request) throws Exception {
        if ("".equals(userCode.trim()) || userCode == null || "".equals(userPassword.trim()) || userPassword == null) {
            request.setAttribute("error", "登录失败,请输入账号或密码!");
        } else {
            User user = userService.login(userCode, userPassword);
            if (null != user) {
                //登录成功 保存用户信息
                request.getSession().setAttribute("user", user);
                return "redirect:/sys/index.html";
            }
        }
        request.setAttribute("error", "登录失败,您的账号或密码错误!");
        return "forward:/login.html";
    }

    /**
     * 用户登出
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logOut(HttpSession session) {
        //移除用户
        session.removeAttribute("user");
        //重定向登入页面
        return  "redirect:/login.html";
    }
}
