package com.beerus.dao.impl;

import com.beerus.dao.CusCustomerDao;
import com.beerus.entity.CusCustomer;
import com.beerus.utils.HibernateUtils;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public class CusCustomerDaoImpl implements CusCustomerDao {
    public List<CusCustomer> listCusTomers() {
        return HibernateUtils.getSession().createQuery("FROM CusCustomer").list();
    }
}
