package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.Users;
import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;
import com.beerus.utils.Mark;
import com.beerus.utils.Result;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 用户Action
 * @Date 2019/4/3
 **/
public class UserAction extends ActionSupport {
    //用户名
    private String name;
    //密码
    private String password;
    //确认密码
    private String repassword;
    //输出消息
    private String message;
    //电话号码
    private String telephone;
    //用户姓名
    private String username;
    //标示是什么操作
    private String option;
    //要转的日期
    private Date dateStg;
    //用户数据层
    private UserService userBiz = new UserServiceImpl();

    public Date getDateStg() {
        return dateStg;
    }

    public void setDateStg(Date dateStg) {
        this.dateStg = dateStg;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    /**
     * 用户登录
     *
     * @return 返回是否登录成功
     */
    public String login_User() {
        Users user = userBiz.login(new Users(name, password));
        if (null != user) {
            //登录成功
            //保存用户对象
            ServletActionContext.getRequest().getSession().setAttribute("user", user);
            return SUCCESS;
        } else {
            //登录失败
            message = "登录失败,请检查用户名和密码是否正确!";
            return LOGIN;
        }
    }

    /**
     * 用户注册
     *
     * @return 返回是否注册成功
     */
    public String register_User() {
        Users user = new Users();
        user.setTelephone(telephone);
        user.setName(name);
        user.setPassword(repassword);
        user.setUsername(username);
        user.setIsadmin("1");
        //判断添加结果
        if (0 < userBiz.register(user)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /**
     * ajax验证用户名是否存在
     *
     * @return
     */
    public String checkName_User() throws Exception {
        Result result = new Result(1000, "notexetis");
        if (userBiz.checkUserName(name)) {
            result.setCode(10001);
            result.setMessage("exetis");
        }
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.print(JSON.toJSON(result));
        return null;
    }

    /**
     * 数据验证
     */
    @Override
    public void validate() {
        //判断标示变量
        if (null == option || option.trim().length() <= 0)
            return;

        if ("login".equals(option)) {
            //登录验证
            if (!check_Login()) {
                addFieldError("msg", "用户名或账号密码不能为空!");
            }
        } else if ("register".equals(option)) {
            //注册验证
            if (!check_Register()) {
                addFieldError("msg", "请填写完整的注册信息!");
            }
        }
    }

    /**
     * 验证登录
     *
     * @return 是否登录成功
     */
    private boolean check_Login() {
        if (null == name || "".equals(name.trim()) || null == password || "".equals(password.trim())) {
            return Mark.ERROR_B;
        }
        return Mark.SUCCESS_B;
    }

    /**
     * 验证注册
     *
     * @return 是否注册成功
     */
    private boolean check_Register() {
        if (null == name || "".equals(name.trim()) || null == password || "".equals(password.trim()) || null == telephone || "".equals(telephone.trim()) || null == username || "".equals(username.trim())) {
            return Mark.ERROR_B;
        }
        return Mark.SUCCESS_B;
    }
}
