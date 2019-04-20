package com.beerus.dao.impl;

import com.beerus.dao.SaleDao;
import com.beerus.entity.SaleOrder;
import com.beerus.entity.SaleProduct;
import com.beerus.utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public class SaleDaoImpl implements SaleDao {
    public int save(SaleOrder saleOrder) {
        return (Integer) HibernateUtils.getSession().save(saleOrder);
    }

    public List<SaleProduct> listFindAll() {
        return HibernateUtils.getSession().createQuery("FROM SaleProduct").list();
    }

    public SaleOrder getOrder(Class clzz, Serializable serializable) {
        return (SaleOrder)HibernateUtils.getSession().load(clzz,serializable);
    }
}
