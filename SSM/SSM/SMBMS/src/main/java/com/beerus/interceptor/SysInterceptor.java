package com.beerus.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Beerus
 * @Description 系统控制器 用来判断是否登录
 * @Date 2019-05-10
 **/
public class SysInterceptor extends HandlerInterceptorAdapter {
    /**
     * 会话用户
     */
    private final String SESSION_USER = "user";

    /**
     * 在进入控制器之前拦截客户端发送过来的请求
     *
     * @param request
     * @param response
     * @param handler
     * @param handler
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (null == request.getSession().getAttribute(SESSION_USER)) {
            //暂未登入 跳到登入页面
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        //已登录 进入拦截器
        return true;
    }


}
