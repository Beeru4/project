package com.beerus.mapper;


import com.beerus.entity.Bill;

import java.util.List;
import java.util.Map;

/**
 * 订单数据层
 */
public interface BillMapper {
    /**
     * 根据条件或分页查询订单
     *
     * @param params 条件
     * @return 订单集合
     */
    List<Bill> list_FindBillByFilterOrPage(Map<String, Object> params) throws Exception;

    /**
     * 查询总行数
     *
     * @param params 条件
     * @return 总行数
     */
    int count_Total(Map<String, Object> params) throws Exception;

    /**
     * 根据编码检查订单是否存在
     *
     * @param code 订单编码
     * @return
     */
    int count_ByCode(String code) throws Exception;

    /**
     * 添加订单
     *
     * @param bill
     * @return
     */
    int save_Bill(Bill bill) throws Exception;

    /**
     * 根据ID查询单条订单
     *
     * @param bId
     * @return
     */
    Bill get_ByBillId(Integer bId) throws Exception;

    /**
     * 根据ID修改订单
     *
     * @param bill 修改的订单
     * @return
     */
    int update_ByBillId(Bill bill) throws Exception;

    /**
     * 根据ID删除订单
     *
     * @param id 订单ID
     * @return
     */
    int delete_ByBillId(Integer id) throws Exception;
}
