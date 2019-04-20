package com.beerus.service.impl;

import com.beerus.dao.TypeDao;
import com.beerus.dao.impl.TypeDaoImpl;
import com.beerus.entity.Type;
import com.beerus.service.TypeService;

import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/6
 **/
public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();

    public List<Type> listFindAll() {
        return typeDao.listFindAll();
    }
}
