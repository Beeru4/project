package com.beerus.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @Author Beerus
 * @Description 退出Action
 * @Date 2019/4/24
 **/
@Controller
@Component("exitAction")
@Scope("prototype")
public class ExitAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //移除用户
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        return SUCCESS;
    }
}
