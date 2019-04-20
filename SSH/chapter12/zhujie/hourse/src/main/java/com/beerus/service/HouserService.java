package com.beerus.service;

import com.beerus.entity.House;
import com.beerus.utils.Page;
import org.hibernate.HibernateException;

import java.util.List;

public interface HouserService {
    /**
     * 查找所有租房
     * @return 房屋集合
     */
    List<House> listFindAllHouse();
    /**
     * 根据用户查找租房
     * @param id 用户id
     * @return 房屋集合
     */
    List<House> listFindByUserHouse(Integer id);
    /**
     * 添加房屋信息
     * @param house 添加的房屋
     * @return 房屋主键
     */
    Integer saveHouse(House house);

    /**
     * 根据条件查询数据
     *
     * @return 房屋集合
     */
    List<House> listByConditionHouse(House params) throws HibernateException;
    /**
     * 根据分页查询数据
     *
     * @param params     条件
     * @param currPageNo 当前页码
     * @param pageSize   也大小
     * @return
     * @throws HibernateException
     */
   Page<House> listByPageHouse(House params, int currPageNo, int pageSize) throws HibernateException;

    /**
     * 根据id查询指定房源
     *
     * @param id id
     * @return 房源
     */
    House getHouseById(Integer id);
}
