package com.beerus.service;

import com.beerus.entity.SaleOrder;
import com.beerus.entity.SaleProduct;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public interface SaleService {
    /**
     * 添加订单
     * @param saleOrder  订单
     * @return 是否添加成功
     */
    boolean save(SaleOrder saleOrder);
    /**
     * 查询所有产品名称
     * @return
     */
    List<SaleProduct> searchFindAll();

    /**
     * 查找对应订单
     * @param clzz
     * @param serializable
     * @return
     */
    SaleOrder findOrder(Class clzz, Serializable serializable);
}
