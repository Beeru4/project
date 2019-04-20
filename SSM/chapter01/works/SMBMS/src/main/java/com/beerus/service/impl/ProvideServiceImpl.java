package com.beerus.service.impl;

import com.beerus.entity.SmbmsProvider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.mapper.impl.ProvideMapperImpl;
import com.beerus.service.ProvideService;

import java.util.List;

/**
 * @Author Beerus
 * @Description 供应商业务层实现类
 * @Date 2019/4/19
 **/
public class ProvideServiceImpl implements ProvideService {
    private ProvideMapper provideMapper = new ProvideMapperImpl();

    @Override
    public int count_TotalRow() throws Exception {
        return provideMapper.count_TotalRow();
    }

    @Override
    public int count_TotalRow2() throws Exception {
        return provideMapper.count_TotalRow2();
    }

    @Override
    public List<SmbmsProvider> list_FindAll() throws Exception {
        return provideMapper.list_FindAll();
    }
}
