package com.beerus.service.impl;

import com.beerus.dao.SaleDao;
import com.beerus.dao.impl.SaleDaoImpl;
import com.beerus.entity.SaleOrder;
import com.beerus.entity.SaleProduct;
import com.beerus.service.SaleService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/11
 **/
public class SaleServiceImpl implements SaleService {
    private SaleDao saleDao = new SaleDaoImpl();

    public boolean save(SaleOrder saleOrder) {
        return saleDao.save(saleOrder) > 0;
    }

    public List<SaleProduct> searchFindAll() {
        return saleDao.listFindAll();
    }

    public SaleOrder findOrder(Class clzz, Serializable serializable) {
        return saleDao.getOrder(clzz,serializable);
    }
}
