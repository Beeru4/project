package com.beerus.mapper;

import com.beerus.entity.SmbmsProvider;

import java.util.List;

/**
 * 供应商数据层
 */
public interface ProvideMapper {
    /**
     * 查询总行数
     *
     * @return
     */
    int count_TotalRow() throws Exception;

    /**
     * 查询总行数2
     *
     * @return
     */
    int count_TotalRow2() throws Exception;

    /**
     * 查询所有供应商
     * @return
     * @throws Exception
     */
    List<SmbmsProvider> list_FindAll() throws  Exception;
}
