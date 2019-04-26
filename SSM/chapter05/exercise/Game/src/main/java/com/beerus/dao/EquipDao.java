package com.beerus.dao;

import com.beerus.entity.Equip;

/**
 * 装备数据层
 */
public interface EquipDao {
    /**
     * 修改指环
     *
     * @param equip
     * @return
     */
    int update_Ring(Equip equip);
}
