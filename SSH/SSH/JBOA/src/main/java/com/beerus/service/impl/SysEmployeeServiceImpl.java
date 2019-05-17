package com.beerus.service.impl;

import com.beerus.dao.SysEmployeeDao;
import com.beerus.dao.impl.SysEmployeeDaoImpl;
import com.beerus.entity.SysEmployee;
import com.beerus.service.SysEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/15
 **/
@Service(value = "sysEmployeeService")
public class SysEmployeeServiceImpl implements SysEmployeeService {

    @Resource(name = "sysEmployeeDao")
    private SysEmployeeDao sysEmployeeDao;

    public SysEmployee getEmp(SysEmployee employee) {
        Object o = sysEmployeeDao.getEmp(employee);
        return o == null ? null : (SysEmployee) o;
    }
}
