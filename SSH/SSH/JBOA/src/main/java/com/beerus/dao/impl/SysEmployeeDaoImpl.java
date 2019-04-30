package com.beerus.dao.impl;


import com.beerus.dao.SysEmployeeDao;
import com.beerus.entity.SysEmployee;
import com.beerus.utils.HibernateUtils;

/**
 * @Author Beerus
 * @Description 用户数据层实现类
 * @Date 2019/4/15
 **/
public class SysEmployeeDaoImpl implements SysEmployeeDao {
    public Object getEmp(SysEmployee employee) {
        return HibernateUtils.getSession().createQuery(
                "FROM SysEmployee WHERE sn = :sn AND password = :password AND status='在职' ").setProperties(employee).uniqueResult();
    }
}
