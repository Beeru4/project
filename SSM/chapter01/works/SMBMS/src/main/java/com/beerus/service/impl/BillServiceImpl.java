package com.beerus.service.impl;

import com.beerus.entity.SmbmsBill;
import com.beerus.mapper.BillMapper;
import com.beerus.mapper.impl.BillMapperImpl;
import com.beerus.service.BillService;
import com.beerus.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author Beerus
 * @Description 订单业务层
 * @Date 2019/4/20
 **/
public class BillServiceImpl implements BillService {
    private BillMapper billMapper = new BillMapperImpl();

    @Override
    public Page<SmbmsBill> findAllByFilter(SmbmsBill smbmsBill, int currPageNo, int pageSize) throws Exception {
        Page<SmbmsBill> page = new Page<>();
        page.setPages(billMapper.list_ByFilter(smbmsBill));
        return page;
    }

    @Override
    public List<SmbmsBill> list_findByInAndArray(Integer[] provIds) throws Exception {
        return billMapper.list_findByInAndArray(provIds);
    }

    @Override
    public List<SmbmsBill> list_findByInAndList(List<Integer> provIds) throws Exception {
        return billMapper.list_findByInAndList(provIds);
    }

    @Override
    public List<SmbmsBill> list_findByInAdnMap(Map<String, Object> params) throws Exception {
        return billMapper.list_findByInAdnMap(params);
    }


}
