package com.beerus.service;

import com.beerus.entity.SmbmsProvider;
import com.beerus.utils.Page;

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
     * @param currPageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    Page<SmbmsProvider> list_FindAll(Integer currPageNo,Integer pageSize) throws Exception;

    /**
     * 添加订单
     *
     * @param smbmsProvider
     * @return
     */
    boolean save_Prov(SmbmsProvider smbmsProvider) throws Exception;

    /**
     * 修改订单
     *
     * @param smbmsProvider
     * @return
     */
    boolean update_Prov(SmbmsProvider smbmsProvider) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete_Prov(Integer id) throws Exception;

    /**
     * 根据条件+choose查询供应商
     *
     * @param smbmsProvider 条件
     * @return
     * @throws Exception
     */
    List<SmbmsProvider> list_FindByFilter(SmbmsProvider smbmsProvider) throws Exception;
}
