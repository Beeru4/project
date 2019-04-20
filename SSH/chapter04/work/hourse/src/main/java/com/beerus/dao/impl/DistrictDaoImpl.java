package com.beerus.dao.impl;

import com.beerus.dao.DistrictDao;
import com.beerus.entity.District;
import com.beerus.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;


public class DistrictDaoImpl implements DistrictDao {


    public List<District> findAllDis() throws HibernateException {
        Query query = HibernateUtils.getSession().createQuery("FROM District");
        return query.list();
    }
}
