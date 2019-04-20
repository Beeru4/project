package com.beerus.dao;

import com.beerus.entity.CusCustomer;

import java.util.List;

/**
 * 用户数据层
 */
public interface CusCustomerDao {
    /**
     * 查询所有用户
     * @return 用户
     */
    List<CusCustomer> listCusTomers();
}
