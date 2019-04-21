package com.beerus.service;

import com.beerus.entity.SmbmsBill;
import com.beerus.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单业务层
 * @Date 2019/4/20
 **/
public interface BillService {
    /**
     * 根据条件查询所有订单
     *
     * @param smbmsBill  条件
     * @param currPageNo 当前页码
     * @param pageSize   页大小
     * @return
     * @throws Exception
     */
    Page<SmbmsBill> findAllByFilter(SmbmsBill smbmsBill, int currPageNo, int pageSize) throws Exception;
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
     * @param params
     * @return
     * @throws Exception
     */
    List<SmbmsBill> list_findByInAdnMap(Map<String, Object> params) throws Exception;
}
