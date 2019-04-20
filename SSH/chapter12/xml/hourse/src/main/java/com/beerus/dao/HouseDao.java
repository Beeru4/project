package com.beerus.dao;

import com.beerus.entity.House;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * 房屋信息数据层
 */
public interface HouseDao {
    /**
     * 查找所有租房
     *
     * @return 房屋集合
     */
    List<House> listFindAllHouse() throws HibernateException;

    /**
     * 根据用户查找租房
     *
     * @param id 用户id
     * @return 房屋集合
     */
    List<House> listFindByUserHouse(Integer id) throws HibernateException;

    /**
     * 添加房屋信息
     *
     * @param house 添加的房屋
     * @return 房屋主键
     */
    Integer saveHouse(House house) throws HibernateException;

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
    List<House> listByPageHouse(House params, int currPageNo, int pageSize) throws HibernateException;

    /**
     * 查询总行数
     *
     * @param params 条件
     * @return 总行数
     */
    Long totalRow(House params);

    /**
     * 根据id查询指定房源
     *
     * @param id id
     * @return 房源
     */
    House getHouseById(Integer id);
}
