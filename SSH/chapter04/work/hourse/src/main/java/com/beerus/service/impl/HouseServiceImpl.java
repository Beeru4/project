package com.beerus.service.impl;

import com.beerus.dao.HouseDao;
import com.beerus.dao.impl.HouseDaoImpl;
import com.beerus.entity.House;
import com.beerus.service.HouserService;
import com.beerus.utils.Page;
import org.hibernate.HibernateException;

import java.util.List;

public class HouseServiceImpl implements HouserService {
    private HouseDao houseDao = new HouseDaoImpl();

    public List<House> listFindAllHouse() {
        return houseDao.listFindAllHouse();
    }

    public List<House> listFindByUserHouse(Integer id) {
        return houseDao.listFindByUserHouse(id);
    }

    public Integer saveHouse(House house) {
        return houseDao.saveHouse(house);
    }

    public List<House> listByConditionHouse(House params) throws HibernateException {
        return houseDao.listByConditionHouse(params);
    }

    public Page<House> listByPageHouse(House params, int currPageNo, int pageSize) throws HibernateException {
        Page<House> page = new Page<House>();
        page.setCurrPageNo(currPageNo);
        page.setPageSize(pageSize);
        page.setTotalCount(houseDao.totalRow(params).intValue());
        page.setTotalPage((page.getTotalCount() + pageSize - 1) / pageSize);
        page.setPages(houseDao.listByPageHouse(params, currPageNo, pageSize));
        return page;
    }

    public House getHouseById(Integer id) {
        return houseDao.getHouseById(id);
    }
}
