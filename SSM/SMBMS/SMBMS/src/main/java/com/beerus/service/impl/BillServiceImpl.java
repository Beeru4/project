package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Bill;
import com.beerus.mapper.BillMapper;
import com.beerus.mapper.impl.BillMapperImpl;
import com.beerus.service.BillService;
import com.beerus.utils.Page;

import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单业务层
 * @Date 2019/4/20
 **/
public class BillServiceImpl implements BillService {

    private BillMapper billMapper = new BillMapperImpl();

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    public Page<Bill> list_FindAll(Map<String, Object> params) throws Exception {
        Page<Bill> billPage = new Page<Bill>();
        //设置页大小
        billPage.setPageSize((Integer) params.get("pageSize"));
        //设置总行数
        billPage.setTotalCount(billMapper.count_Total(params));
        //设置当前页码
        billPage.setCurrPageNo((((Integer) params.get("currPageNo")) - 1) * billPage.getPageSize());
        //设置总页码
        billPage.setTotalPage((billPage.getTotalCount() + billPage.getPageSize() - 1) / billPage.getPageSize());
        //重置页码
        params.put("currPageNo", billPage.getCurrPageNo());
        //设置查询数据
        billPage.setPages(billMapper.list_FindBillByFilterOrPage(params));
        return billPage;
    }

    public boolean checkCodeIsExists(String code) throws Exception {
        return billMapper.count_ByCode(code) > Mark.ERROR;
    }

    public boolean save_Bill(Bill bill) throws Exception {
        return billMapper.save_Bill(bill) > Mark.ERROR;
    }

    public Bill billView(Integer bId) throws Exception {
        return billMapper.get_ByBillId(bId);
    }

    public boolean billModify(Bill bill) throws Exception {
        return billMapper.update_ByBillId(bill) > 0;
    }

    public boolean delBill(Integer id) throws Exception {
        return billMapper.delete_ByBillId(id) > 0;
    }
}