package com.beerus.service.impl;

import com.beerus.common.Mark;
import com.beerus.entity.SmbmsProvider;
import com.beerus.mapper.ProvideMapper;
import com.beerus.mapper.impl.ProvideMapperImpl;
import com.beerus.service.ProvideService;
import com.beerus.utils.Page;

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
    public Page<SmbmsProvider> list_FindAll(Integer currPageNo, Integer pageSize) throws Exception {
        Page<SmbmsProvider> smbmsProviderPage = new Page<>();
        //设置总行数
        smbmsProviderPage.setTotalCount(provideMapper.count_TotalRow());
        //设置页大小
        smbmsProviderPage.setPageSize(pageSize);
        //设置当前页码
        smbmsProviderPage.setCurrPageNo((currPageNo - 1) * pageSize);
        //设置总页码
        smbmsProviderPage.setTotalPage((smbmsProviderPage.getTotalCount() + pageSize - 1) / pageSize);
        //设置查询数据
        smbmsProviderPage.setPages(provideMapper.list_FindAll(smbmsProviderPage.getCurrPageNo(), pageSize));
        return smbmsProviderPage;
    }

    @Override
    public boolean save_Prov(SmbmsProvider smbmsProvider) throws Exception {
        return provideMapper.save_Prov(smbmsProvider) > Mark.SAVE_ERROR;
    }

    @Override
    public boolean update_Prov(SmbmsProvider smbmsProvider) throws Exception {
        return provideMapper.update_Prov(smbmsProvider) > Mark.UPDATE_ERROR;
    }

    @Override
    public boolean delete_Prov(Integer id) throws Exception {
        return provideMapper.delete_Prov(id) > Mark.DELETE_ERROR;
    }

    @Override
    public List<SmbmsProvider> list_FindByFilter(SmbmsProvider smbmsProvider) throws Exception {
        return provideMapper.list_FindByFilter(smbmsProvider);
    }
}
