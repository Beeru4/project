package com.beerus.dao.mapper;

import com.beerus.entity.SmbmsProvider;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/18
 **/
public interface ProviderMapper {
    /**
     * 查询所有供应商
     * @return
     */
    List<SmbmsProvider> list_AllProv();
}
