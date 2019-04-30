package com.beerus.service;

import com.beerus.entity.SysEmployee;

/**
 * @Author Beerus
 * @Description 员工业务层
 * @Date 2019/4/15
 **/
public interface SysEmployeeService {
    /**
     * 员工登录
     * @param employee 用户
     * @return 查询出来的用户
     */
    SysEmployee getEmp(SysEmployee employee);
}
