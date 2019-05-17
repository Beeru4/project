package com.beerus.interceptor;

import com.beerus.common.Common;
import com.beerus.utils.Utils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Beerus
 * @Description 登录控制器
 * @Date 2019-05-15
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 在进入控制器之前拦截用户是否登入
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录
        Object backend = request.getSession().getAttribute(Common.BACKEND);
        Object dev = request.getSession().getAttribute(Common.DEV);
        if (Utils.isNotNull(backend) || Utils.isNotNull(dev)) {
            //已登入
            return true;
        }
        //未登入
        //提示
        request.getSession().setAttribute("error403",Common.ERROR403);
        response.sendRedirect(request.getContextPath() + "/main.html");
        return false;

    }
}
