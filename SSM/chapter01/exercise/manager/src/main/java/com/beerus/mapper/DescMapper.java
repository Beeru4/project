package com.beerus.mapper;

import com.beerus.entity.Desc;

import java.util.List;

/**
 * 详情详细数据层
 */
public interface DescMapper {
    /**
     * 查询所有详细信息
     * @return
     */
    List<Desc> list_All();
}
