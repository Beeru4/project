package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.Bill;
import com.beerus.mapper.BillMapper;
import com.beerus.service.BillService;
import com.beerus.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单业务层
 * @Date 2019/4/20
 **/
@Service("billService")
@Transactional
public class BillServiceImpl implements BillService {

    /**
     * 订单数据层
     */
    @Resource(name = "billMapper")
    private BillMapper billMapper;

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public boolean checkCodeIsExists(String code) throws Exception {
        return billMapper.count_ByCode(code) > Mark.ERROR;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean save_Bill(Bill bill) throws Exception {
        return billMapper.save_Bill(bill) > Mark.ERROR;
    }

    @Transactional(readOnly = true)
    public Bill billView(Integer bId) throws Exception {
        return billMapper.get_ByBillId(bId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean billModify(Bill bill) throws Exception {
        return billMapper.update_ByBillId(bill) > 0;
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean delBill(Integer id) throws Exception {
        return billMapper.delete_ByBillId(id) > 0;
    }
}
