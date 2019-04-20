package com.beerus.dao;

import com.beerus.entity.Users;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * 用户数据层
 */
public interface UserDao {
    /**
     * 添加用户
     *
     * @param user 用户
     */
    void saveUser(Users user) throws HibernateException;

    /**
     * 更具用户账号密码查找用户
     *
     * @param users 用户
     * @return 查找的用户
     */
    Users getByUser(Users users) throws HibernateException;

    /**
     * 查找所有用户
     * @return 用户集合
     */
    List<Users> findAllUser();

    /**
     * 根据用户名得到id
     * @param name
     * @return
     */
    int getUser(String name);
}


