package com.beerus.service;

import com.beerus.entity.BizClaimVoucher;
import com.beerus.utils.Page;

import java.util.List;

public interface CVoucherService {
   /**
    * 保存订单
    * @param claimVoucher
    * @return
    */
   boolean save(BizClaimVoucher claimVoucher);
   /**
    * 分页查询
    * @param claimVoucher
    * @return
    */
  Page<BizClaimVoucher> listAllVoucherById(BizClaimVoucher claimVoucher, int currPageNo, int pageSize);

   /**
    * 根据id查询单条报销单
    * @param id
    * @return
    */
   BizClaimVoucher getVoucher(int id);
}
