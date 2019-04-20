package com.beerus.service.impl;

import com.beerus.dao.CusCustomerDao;
import com.beerus.dao.impl.CusCustomerDaoImpl;
import com.beerus.entity.CusCustomer;
import com.beerus.service.CusCustomerService;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public class CusCustomerServiceImpl implements CusCustomerService {
    private CusCustomerDao customerDao = new CusCustomerDaoImpl();
    public List<CusCustomer> listFinName() {
        return customerDao.listCusTomers();
    }
}
