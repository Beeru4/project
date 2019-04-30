package com.beerus.service.impl;

import com.beerus.dao.SysEmployeeDao;
import com.beerus.dao.impl.SysEmployeeDaoImpl;
import com.beerus.entity.SysEmployee;
import com.beerus.service.SysEmployeeService;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/15
 **/
public class SysEmployeeServiceImpl implements SysEmployeeService {
    private SysEmployeeDao sysEmployeeDao = new SysEmployeeDaoImpl();

    public SysEmployee getEmp(SysEmployee employee) {
        Object o = sysEmployeeDao.getEmp(employee);
        return o == null ? null : (SysEmployee) o;
    }
}
