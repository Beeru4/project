package com.beerus.service;

import com.beerus.entity.District;

import java.util.List;

/**
 * 区县业务层
 */
public interface DistrictService  {

    /**
     * 查询所有区县
     * @return 返回区县集合
     */
    List<District> findAllDis();
}
