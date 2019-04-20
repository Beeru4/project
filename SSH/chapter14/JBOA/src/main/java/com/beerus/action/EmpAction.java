package com.beerus.action;

import com.beerus.entity.SysEmployee;
import com.beerus.service.SysEmployeeService;
import com.beerus.service.impl.SysEmployeeServiceImpl;
import com.beerus.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Beerus
 * @Description 员工Action
 * @Date 2019/4/15
 **/
public class EmpAction extends ActionSupport {
    private SysEmployeeService empBiz = new SysEmployeeServiceImpl();
    //账号
    private String sn;
    //密码
    private String password;
    //错误信息
    private String msg;
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 登录
     *
     * @return
     */
    public String login() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SysEmployee employee = empBiz.getEmp(new SysEmployee(sn, MD5Util.EncoderByMd5(password)));
        //判读是否登录成功
        if (employee != null) {
            //登录成功 保存对象
            ServletActionContext.getRequest().getSession().setAttribute("emp", employee);
            ServletActionContext.getRequest().getSession().setAttribute("postion", employee.getDepartment().getName());
            return SUCCESS;
        }
        //登录失败
        msg = "账号或密码错误";
        return LOGIN;
    }

    /**
     * 数据验证
     */
    @Override
    public void validate() {
        if (sn == null || sn.length() == 0 || password == null || password.length() == 0) {
            addFieldError("", "");
            msg = "请输入账号或密码";
        }
    }
}
