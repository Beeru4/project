package com.beerus.controller;

import com.beerus.common.Common;
import com.beerus.pojo.BackendUser;
import com.beerus.pojo.DevUser;
import com.beerus.service.BackendUserService;
import com.beerus.service.DevUserService;
import com.beerus.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Beerus
 * @Description 登录控制器
 * @Date 2019-05-15
 **/
@Controller
public class LoginController {

    private final static String MAIN = "/sys/index.html";

    /**
     * 开发者业务层
     */
    @Resource(name = "devUserService")
    private DevUserService devUserService;
    /**
     * 后台业务层
     */
    @Resource(name = "backendUserService")
    private BackendUserService backendUserService;

    /**
     * 后台登入
     *
     * @param userCode     用户编码
     * @param userPassword 用户密码
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/backenddologin")
    public String backendDoLogin(@RequestParam(value = "userCode", required = false) String userCode,
                                 @RequestParam(value = "userPassword", required = false) String userPassword,
                                 HttpServletRequest request) throws Exception {
        if (Utils.isNotEmptyAndNull(userCode) && Utils.isNotEmptyAndNull(userPassword)) {
            //执行登录
            BackendUser backendUser = backendUserService.login(userCode, userPassword);
            //判断是否登录成功
            if (Utils.isNotNull(backendUser)) {
                //登录成功保存用户
                request.getSession().setAttribute(Common.BACKEND_SESSION, backendUser);
                //保存标示变量 当页面重定向到主页的时候会更具这个标示变量来判断跳到开发者页面还是后台页面
                request.getSession().setAttribute(Common.BACKEND, Common.BACKEND);
                return Common.REDIRECT + MAIN;
            }
            //登入失败跳回登入页面
            request.setAttribute(Common.ERROR, Common.LOGINERROR);
        } else {
            request.setAttribute(Common.ERROR, Common.LOGINNULL);
        }
        return Common.FORWARD + "/backendlogin.html";
    }

    /**
     * 开发者登入
     *
     * @param devCode     开发者编码
     * @param devPassword 开发者密码
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/devdologin")
    public String devDoLogin(@RequestParam(value = "devCode", required = false) String devCode,
                             @RequestParam(value = "devPassword", required = false) String devPassword,
                              HttpServletRequest request) throws Exception {
        if (Utils.isNotEmptyAndNull(devCode) && Utils.isNotEmptyAndNull(devPassword)) {
            //执行登录
            DevUser devUser = devUserService.login(devCode, devPassword);
            //判断是否登录成功
            if (Utils.isNotNull(devUser)) {
                //登录成功保存用户
                request.getSession().setAttribute(Common.DEV_SESSION, devUser);
                request.getSession().setAttribute(Common.DEV, Common.DEV);
                return Common.REDIRECT + MAIN;
            }
            //登入失败跳回登入页面
            request.setAttribute(Common.ERROR, Common.LOGINERROR);
        } else {
            request.setAttribute(Common.ERROR, Common.LOGINNULL);
        }
        return Common.FORWARD + "/devlogin.html";
    }
}
