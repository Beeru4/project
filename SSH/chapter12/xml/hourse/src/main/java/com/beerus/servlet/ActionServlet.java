package com.beerus.servlet;

import com.beerus.entity.Users;
import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;
import com.beerus.utils.Mark;
import com.beerus.utils.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Beerus
 * @Description 控制Servlet
 * @Date 2019/3/29
 **/

@WebServlet("/actionServlet")
public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到标示变量
        String action = req.getParameter("action");
        if (null == action) {
            return;
        }
        UserService userBiz = null;
        PrintWriter writer = resp.getWriter();
        //接收结果
        //判断是什么请求
        if ("login".equals(action)) {
            //登录
            userBiz = new UserServiceImpl();
            String name = req.getParameter("name");
            String pwd = req.getParameter("password");
            if (null != name && !"".equals(name.trim()) && null != pwd && !"".equals(pwd.trim())) {
                Users user = userBiz.login(new Users(name, pwd));
                if (null != user) {
                    req.getSession().setAttribute("user", user);
                    writer.print(Tool.currentScript("登录成功!","page/show.jsp"));
                } else {
                    writer.print(Tool.currentScript("账号或密码错误!","page/login_struts2.jsp"));
                }
            }

        } else if ("register".equals(action)) {
            //注册
            userBiz = new UserServiceImpl();
            String pwd = req.getParameter("repassword");
            String name = req.getParameter("name");
            String userName = req.getParameter("username");
            String phone = req.getParameter("telephone");
            if (null != name && !"".equals(name.trim()) && null != pwd && !"".equals(pwd.trim()) && null != userName && !"".equals(userName.trim()) && null != phone && !"".equals(phone.trim())) {
                Users users = new Users();
                users.setUsername(userName);
                users.setPassword(pwd);
                users.setName(name);
                users.setTelephone(phone);
                if(userBiz.register(users) > Mark.ERROR_I){
                    writer.print(Tool.currentScript("注册成功!","page/login_struts2.jsp"));
                }else{
                    writer.print(Tool.currentScript("注册失败!","page/register.jsp"));
                }
            }
        }


        if (null != writer) {
            writer.close();
        }
    }
}
