package com.beerus.action;

import com.alibaba.fastjson.JSON;
import com.beerus.entity.CusCustomer;
import com.beerus.service.CusCustomerService;
import com.beerus.service.impl.CusCustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author Beerus
 * @Description 用户Action
 * @Date 2019/4/11
 **/
public class CustomerAction extends ActionSupport {

    //用户业务层
    private CusCustomerService customerService = new CusCustomerServiceImpl();

    /**
     * 查询所有用户
     *
     * @return
     */
    public String search_Customer() throws IOException {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        List<CusCustomer> cusCustomers = customerService.listFinName();
        writer.print(JSON.toJSONString(cusCustomers));
        return null;
    }
}
