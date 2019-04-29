package com.beerus.service;


import com.beerus.entity.Bill;
import com.beerus.utils.Page;

import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单业务层
 * @Date 2019/4/20
 **/
public interface BillService {
    /**
     * 根据分页或条件查询所有
     *
     * @param params
     * @return
     */
    Page<Bill> list_FindAll(Map<String, Object> params) throws Exception;


    /**
     * 根据编码检查订单是否存在
     *
     * @param code 订单编码
     * @return
     */
    boolean checkCodeIsExists(String code) throws Exception;

    /**
     * 添加订单
     *
     * @param bill
     * @return
     */
    boolean save_Bill(Bill bill) throws Exception;


    /**
     * 根据ID查询单条订单
     *
     * @param bId
     * @return
     */
    Bill billView(Integer bId) throws Exception;

    /**
     * 根据ID修改订单
     *
     * @param bill 修改的订单
     * @return
     */
    boolean billModify (Bill bill) throws Exception;

    /**
     * 根据ID删除订单
     *
     * @param id 订单ID
     * @return
     */
    boolean delBill(Integer id) throws Exception;
}
