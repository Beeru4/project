package com.beerus.service;

import com.beerus.entity.Provider;
import com.beerus.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * 供应商业务层
 */
public interface ProvideService {
    /**
     * 查询所有供应商
     *
     * @return 供应商集合
     */
    List<Provider> list_FindProvAll() throws Exception;

    /**
     * 根据分页或条件查询所有
     *
     * @param params
     * @return
     */
    Page<Provider> list_FindAll(Map<String, Object> params) throws Exception;

    /**
     * 根据ID查询供应商
     *
     * @param id
     * @return
     */
    Provider view(Integer id) throws Exception;



    /**
     * 添加供应商
     *
     * @param provider
     * @return
     * @throws Exception
     */
    boolean save(Provider provider) throws Exception;

    /**
     * 根据ID修改供应商
     *
     * @param provider
     * @return
     * @throws Exception
     */
    boolean update(Provider provider) throws Exception;

    /**
     * 根据ID删除供应商
     *
     * @param id
     * @return
     */
    boolean delete(Integer id) throws Exception;



    /**
     * 根据ID检查供应商编码是否存在
     *
     * @param code
     * @return
     */
    boolean checkProCode(String code) throws Exception;

    /**
     * 根据ID删除之前查询该供应商下是否有订单
     *
     * @param id
     * @return
     */
    Integer count_ByDel(Integer id) throws Exception;

}
