package com.beerus.dao;

import com.beerus.entity.SaleOrder;
import com.beerus.entity.SaleOrderLine;
import com.beerus.entity.SaleProduct;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public interface SaleDao {
    /**
     * 添加订单
     *
     * @param saleOrder
     * @return
     */
    int save(SaleOrder saleOrder);

    /**
     * 查询所有产品名称
     *
     * @return
     */
    List<SaleProduct> listFindAll();

    /**
     * 查找订单
     * @param clzz
     * @param serializable
     * @return
     */
    SaleOrder getOrder(Class clzz, Serializable serializable);
}
