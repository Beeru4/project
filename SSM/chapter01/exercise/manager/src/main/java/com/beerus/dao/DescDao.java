package com.beerus.dao;

import com.beerus.entity.Desc;

import java.util.List;

/**
 * 详情详细数据层
 */
public interface DescDao {
    /**
     * 查询所有详细信息
     * @return
     */
    List<Desc> list_All();
}
