package com.beerus.service;

import com.beerus.entity.Type;

import java.util.List;

/**
 * @Author Beerus
 * @Description 类型业务层
 * @Date 2019/4/6
 **/
public interface TypeService {
    /**
     * 查询所有房屋类型
     * @return 类型集合
     */
    List<Type> listFindAll();
}
