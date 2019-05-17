package com.beerus.service.impl;

import com.beerus.mapper.AppCategoryMapper;
import com.beerus.service.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Beerus
 * @Description 级别业务层实现类
 * @Date 2019-05-16
 **/
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {

    /**
     * 级别业务层
     */
    @Resource(name = "appCategoryMapper")
    private AppCategoryMapper appCategoryMapper;

    public List<com.beerus.pojo.AppCategory> listQueryLevel(Integer level, Integer levelId) {
        return appCategoryMapper.listQueryLevel(level, levelId);
    }
}
