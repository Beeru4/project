package com.beerus.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Beerus
 * @Description 级别业务层
 * @Date 2019-05-16
 **/
public interface AppCategoryService {
    /**
     * 查询分类
     * level = 1 一级,
     * level = 2 二级,
     * level = 3 三级,
     *
     * @param level   级别标示变量
     * @param levelId 级别ID
     * @return
     */
    List<com.beerus.pojo.AppCategory> listQueryLevel(@Param(value = "level") Integer level,
                                                     @Param(value = "levelId") Integer levelId);
}
