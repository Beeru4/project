package com.beerus.mapper;

import com.beerus.entity.SmbmsBill;

import java.util.List;
import java.util.Map;

/**
 * 订单数据层
 */
public interface BillMapper {
    /**
     * 根据条件和分页查询订单表
     *
     * @param smbmsBill  条件
     * @param currPageNo 当前页码
     * @param pageSize   页大小 //, int currPageNo, int pageSize
     * @return
     */
    List<SmbmsBill> list_ByFilter(SmbmsBill smbmsBill) throws Exception;

    /**
     * 查询总行数
     *
     * @return
     */
    int cout_Row();

    /**
     * 根据条件或者分页查询订单
     *
     * @param params
     * @return
     */
    List<SmbmsBill> list_findByFilterOrPage(Map<String, Object> params);

    /**
     * 使用foreach+数组查询供应商下的订单
     *
     * @param provIds 供应商数组
     * @return
     */
    List<SmbmsBill> list_findByInAndArray(Integer[] provIds) throws Exception;

    /**
     * 使用foreach+集合查询供应商下的订单
     *
     * @param provIds
     * @return
     */
    List<SmbmsBill> list_findByInAndList(List<Integer> provIds) throws Exception;

    /**
     * 使用foreach+Map集合+模糊查询查询供应商下的订单
     *
     * @param params
     * @return
     * @throws Exception
     */
    List<SmbmsBill> list_findByInAdnMap(Map<String, Object> params) throws Exception;
}
