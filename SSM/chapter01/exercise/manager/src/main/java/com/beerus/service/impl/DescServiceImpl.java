package com.beerus.service.impl;

import com.beerus.entity.Desc;
import com.beerus.mapper.DescMapper;
import com.beerus.service.DescService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Beerus
 * @Description 业务层
 * @Date 2019-05-05
 **/
@Service("descService")
public class DescServiceImpl implements DescService {
    @Resource(name = "descMapper")
    private DescMapper descMapper;

    public List<Desc> list_All() {
        return descMapper.list_All();
    }
}
