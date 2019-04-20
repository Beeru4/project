package com.beerus.service;

import com.beerus.entity.SmbmsProvider;

import java.util.List;

/**
 * 供应商业务层
 */
public interface ProvideService {
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
