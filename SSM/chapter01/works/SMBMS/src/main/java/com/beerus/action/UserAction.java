package com.beerus.action;

import com.beerus.entity.SmbmsUser;
import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author Beerus
 * @Description 用户Action
 * @Date 2019/4/21
 **/
public class UserAction extends ActionSupport {

    private UserService userService = new UserServiceImpl();

    private String userCode;//用户编码
    private String userPassword;//用户密码

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String execute() throws Exception {
        SmbmsUser smbmsUser = userService.login(userCode, userPassword);
        if (null != smbmsUser) {
            //登录成功 保存用户
            ActionContext.getContext().getSession().put("user", smbmsUser);
            return SUCCESS;
        }
        return ERROR;
    }
}
