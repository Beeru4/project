package com.beerus.dao;

import com.beerus.entity.SmbmsProvider;

import java.util.List;

/**
 * 供应商数据层
 */
public interface ProviderDao {
    /**
     * 查询总行数
     *
     * @return
     */
    int count_Total() throws Exception;

    /**
     * 根据实例直接运行
     *
     * @return
     */
    List<SmbmsProvider> listALlProvByMapperXML();

    /**
     * 基于Mapper直接映射
     * @return
     */
    List<SmbmsProvider> listAllProv();
}
