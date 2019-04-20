package com.beerus.dao;

import com.beerus.entity.BizClaimVoucher;

import java.io.Serializable;
import java.util.List;

/**
 * 报销单数据层
 */
public interface CVoucherDao {
    /**
     * 保存报销单
     * @param claimVoucher
     * @return 是否保存成功
     */
    Serializable save(BizClaimVoucher claimVoucher);

    /**
     * 分页查询
     * @param claimVoucher 订单
     * @param currSize 当前页码
     * @param pageSize 页大小
     * @return
     */
    List<BizClaimVoucher> listAllVoucherByFilter(BizClaimVoucher claimVoucher,int currSize,int pageSize);

    /**
     * 查询所有总行数
     * @param claimVoucher
     * @return
     */
    int count_Row(BizClaimVoucher claimVoucher);

    /**
     * 根据id查询单条报销单
     * @param id
     * @return
     */
    BizClaimVoucher getVoucher(int id);
}
