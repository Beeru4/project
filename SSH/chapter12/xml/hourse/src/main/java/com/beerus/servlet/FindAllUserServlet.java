package com.beerus.servlet;

import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Beerus
 * @Description 查找所有用户
 * @Date 2019/4/3
 **/
@WebServlet("/findAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //调用业务层查询数据
        UserService userBiz = new UserServiceImpl();
        //保存数据
        req.setAttribute("userList", userBiz.findAllUser());
        //转发页面
        req.getRequestDispatcher("showUser.jsp").forward(req,resp);

    }
}
