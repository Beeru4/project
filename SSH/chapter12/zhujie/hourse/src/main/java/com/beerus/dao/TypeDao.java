package com.beerus.dao;

import com.beerus.entity.Type;

import java.util.List;

/**
 * @Author Beerus
 * @Description 类型数据层
 * @Date 2019/4/4
 **/
public interface TypeDao {
    /**
     * 查询所有房屋类型
     * @return 类型集合
     */
    List<Type> listFindAll();

}
