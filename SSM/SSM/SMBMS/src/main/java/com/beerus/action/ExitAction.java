package com.beerus.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * @Author Beerus
 * @Description 退出Action
 * @Date 2019/4/24
 **/
public class ExitAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //移除用户
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        return SUCCESS;
    }
}
