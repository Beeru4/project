package com.beerus.service.impl;

import com.beerus.dao.CVoucherDao;
import com.beerus.dao.impl.CVoucherDaoImpl;
import com.beerus.entity.BizClaimVoucher;
import com.beerus.service.CVoucherService;
import com.beerus.utils.Page;


/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/15
 **/
public class CVoucherServiceImpl implements CVoucherService {
    private CVoucherDao cVoucherDao = new CVoucherDaoImpl();

    public boolean save(BizClaimVoucher claimVoucher) {
        if ((Integer) cVoucherDao.save(claimVoucher) > 0) {
            return true;
        }
        return false;
    }

    public Page<BizClaimVoucher> listAllVoucherById(BizClaimVoucher claimVoucher, int currPageNo, int pageSize) {
        Page<BizClaimVoucher> page = new Page<BizClaimVoucher>();
        page.setCurrPageNo(currPageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(cVoucherDao.count_Row(claimVoucher));
        page.setTotalPage((page.getTotalCount() + pageSize - 1) / pageSize);
        page.setPages(cVoucherDao.listAllVoucherByFilter(claimVoucher,currPageNo,pageSize));
        return page;
    }

    public BizClaimVoucher getVoucher(int id) {
        return cVoucherDao.getVoucher(id);
    }
}
