package com.beerus.dao;

import com.beerus.entity.District;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * 区县数据层
 */
public interface DistrictDao {


    /**
     * 查询所有区县
     * @return 返回区县集合
     */
    List<District> findAllDis() throws HibernateException;
}
