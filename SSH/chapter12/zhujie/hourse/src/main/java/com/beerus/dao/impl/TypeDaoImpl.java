package com.beerus.dao.impl;

import com.beerus.dao.TypeDao;
import com.beerus.entity.Type;
import com.beerus.utils.HibernateUtils;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/4
 **/
public class TypeDaoImpl implements TypeDao {
    public List<Type> listFindAll() {
        return HibernateUtils.getSession().createQuery("FROM Type").list();
    }
}
