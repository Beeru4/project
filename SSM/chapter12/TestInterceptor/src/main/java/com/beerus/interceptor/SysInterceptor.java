package com.beerus.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Beerus
 * @Description 系统拦截器
 * @Date 2019-05-10
 **/
public class SysInterceptor extends HandlerInterceptorAdapter {
    /**
     * 在控制器执行前来接用户请求
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
        if (null == request.getSession().getAttribute("user")) {
            //没登录 重定向到无权限页面
            request.getRequestDispatcher( "/WEB-INF/jsp/error/401.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
