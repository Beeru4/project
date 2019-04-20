package com.beerus.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Author Beerus
 * @Description 登录拦截器
 * @Date 2019/4/9
 **/
public class LoginInterceptor extends AbstractInterceptor {
    /**
     * 实现拦截器方法
     *
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //拿到Action的Name 把登录放过去
        String urlName = actionInvocation.getInvocationContext().getName();
        //拿到登录对象
        Object user = actionInvocation.getInvocationContext().getSession().get("user");
        //判断是否登录
        if (null != user || "login".equals(urlName.trim()) || "checkNameUser".equals(urlName.trim())) {
            //继续执行拦截器或Action
            return actionInvocation.invoke();
        }
        //登录失败 则重新登录
        return Action.LOGIN;
    }
}
