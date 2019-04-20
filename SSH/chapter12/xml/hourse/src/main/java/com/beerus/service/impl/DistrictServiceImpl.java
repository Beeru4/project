package com.beerus.service.impl;

import com.beerus.dao.DistrictDao;
import com.beerus.dao.impl.DistrictDaoImpl;
import com.beerus.entity.District;
import com.beerus.service.DistrictService;
import org.hibernate.HibernateException;

import java.util.List;

public class DistrictServiceImpl implements DistrictService {
    DistrictDao biz = new DistrictDaoImpl();

    
    public List<District> findAllDis() {
        try {
            return biz.findAllDis();
        } catch (HibernateException e) {
            return null;
        }
    }
}
