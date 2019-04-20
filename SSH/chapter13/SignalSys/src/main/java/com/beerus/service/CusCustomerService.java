package com.beerus.service;

import com.beerus.entity.CusCustomer;

import java.util.List;

/**
 * @Author Beerus
 * @Description 用户业务层
 * @Date 2019/4/11
 **/
public interface CusCustomerService {
    /**
     * 查询所有用户名
     * @return
     */
    List<CusCustomer> listFinName();
}
