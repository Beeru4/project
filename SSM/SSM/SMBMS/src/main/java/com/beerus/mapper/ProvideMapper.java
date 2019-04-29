package com.beerus.mapper;

import com.beerus.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 供应商数据层
 */
public interface ProvideMapper {

    /**
     * 查询所有供应商
     *
     * @return 供应商集合
     */
    List<Provider> list_FindProvAll() throws Exception;

    /**
     * 根据条件所有供应商(分页)
     *
     * @param params 条件和页码
     * @return
     * @throws Exception
     */
    List<Provider> list_FindByFilterOrPage(Map<String, Object> params) throws Exception;

    /**
     * 根据ID查询供应商
     *
     * @param id
     * @return
     */
    Provider get_Prov(Integer id) throws Exception;

    /**
     * 查询总行数
     *
     * @param params
     * @return
     */
    Integer count_Total(Map<String, Object> params) throws Exception;

    /**
     * 添加供应商
     *
     * @param provider
     * @return
     * @throws Exception
     */
    Integer save_Prov(Provider provider) throws Exception;

    /**
     * 根据ID修改供应商
     *
     * @param provider
     * @return
     * @throws Exception
     */
    Integer update_Prov(Provider provider) throws Exception;

    /**
     * 根据ID删除供应商
     *
     * @param id
     * @return
     */
    Integer delete_Prov(Integer id) throws Exception;

    /**
     * 根据ID删除之前查询该供应商下是否有订单
     *
     * @param id
     * @return
     */
    Integer count_ByDel(Integer id) throws Exception;

    /**
     * 根据供应商编码检查供应商编码是否存在
     *
     * @param code
     * @return
     */
    Integer count_BySave(@Param("proCode") String code) throws Exception;

}
