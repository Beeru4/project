package com.beerus.action;

import com.beerus.entity.User;
import com.beerus.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.PrintWriter;

/**
 * @Author Beerus
 * @Description 用户Action
 * @Date 2019/4/21
 **/
@Controller
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource(name = "userService")
    private UserService userService;//用户业务层

    private String userCode;//用户编码
    private String userPassword;//用户密码
    private String oldpassword;//旧密码
    private String rnewpassword;//新密码
    private String method;//标示变量

    @Override
    public String execute() throws Exception {
        User user = userService.login(userCode, userPassword);
        if (null != user) {
            //登录成功 保存用户信息
            ActionContext.getContext().getSession().put("user", user);
            return SUCCESS;
        }
        return ERROR;
    }

    /**
     * 检查密码是否一致
     *
     * @return
     * @throws Exception
     */
    public String checkPwd() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        Object user = ServletActionContext.getRequest().getSession().getAttribute("user");
        String result = null;//结果
        if (null == oldpassword) {
            //密码为空
            result = "error";
        } else if (null == user) {
            //用户为空
            result = "sessionerror";
        } else if (((User) user).
                getUserPassword().equals(oldpassword.trim())) {
            //密码一致
            result = "true";
        } else {
            //密码不一致
            result = "false";
        }
        writer.print("{\"result\":\"" + result + "\"}");
        writer.close();
        return null;
    }

    /**
     * 修改密码
     *
     * @return
     */
    public String updatePwd() throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().
                getAttribute("user");
        if (null != rnewpassword) {
            //修改密码
            if (this.userService.updatePassword(user.getId(), rnewpassword)) {
                //修改成功 修改会话当中的密码
                user.setUserPassword(rnewpassword);
                return SUCCESS;
            } else {
                //修改失败
                return null;
            }
        }
        return null;
    }

    @Override
    public void validate() {
        if (null != method && "login".equals(method.trim()))
            //验证账号和密码是否为空
            if (null == userCode || "".equals(userCode.trim()) || null == userPassword || "".equals(userPassword.trim())) {
                this.addActionMessage("账号密码不能为空!");
            }
    }


    public String getRnewpassword() {
        return rnewpassword;
    }

    public void setRnewpassword(String rnewpassword) {
        this.rnewpassword = rnewpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
