package com.beerus.service.impl;

import com.beerus.dao.EquipDao;
import com.beerus.entity.Equip;
import com.beerus.service.EquipService;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/23
 **/
public class EquipServiceImpl implements EquipService {
    //使用IOC注入
    private EquipDao equipDao;

    public void setEquipDao(EquipDao equipDao) {
        this.equipDao = equipDao;
    }


    public int leave_Ring(Equip equip) {
        return equipDao.update_Ring(equip);
    }
}
