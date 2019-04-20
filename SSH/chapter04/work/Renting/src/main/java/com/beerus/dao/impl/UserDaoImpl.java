package com.beerus.dao.impl;

import com.beerus.dao.UserDao;
import com.beerus.entity.Users;
import com.beerus.utils.HibernateUtils;

import java.io.Serializable;

public class UserDaoImpl extends HibernateUtils implements UserDao {
    public void addUser(Users user) {
        getSession().save(user);
    }

    public void update(Users user) {
        getSession().update(user);
    }

    public void delete(Users user) {
        getSession().delete(user);
    }

    public Users query(Class clzz, Serializable id) {
        return (Users) getSession().get(clzz, id);
    }
}
