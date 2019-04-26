package com.beerus.dao.impl;

import com.beerus.dao.EquipDao;
import com.beerus.entity.Equip;

/**
 * @Author Beerus
 * @Description 装备实现类
 * @Date 2019/4/23
 **/
public class EquipDaoImpl implements EquipDao {
    public int update_Ring(Equip equip) {
        if (null != equip) {
            //更改装备名字
            equip.setName("紫色魔幻 + " + equip.getName());
            //更改攻击力
            equip.setAttackPlus(equip.getAttackPlus() + 6);
            //更改防御值
            equip.setDefencePlus(equip.getDefencePlus() + 6);
            //更改成功
            return 1;
        }
        return 0;
    }
}
