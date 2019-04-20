package com.beerus.dao;

import com.beerus.entity.SysEmployee;

/**
 * 员工数据层
 */
public interface SysEmployeeDao {
    /**
     * 查询单个用户
     * @param employee 用户
     * @return 查询出来的用户
     */
    Object getEmp(SysEmployee employee);
}
