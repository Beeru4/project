package com.beerus.dao.impl;

import com.beerus.dao.UserDao;
import com.beerus.entity.Users;
import com.beerus.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class UserDaoImpl extends HibernateUtils implements UserDao {
    public void saveUser(Users user) throws HibernateException {
        getSession().save(user);
    }

    public Users getByUser(Users users) throws HibernateException {
        Query query =  getSession().createQuery("FROM Users WHERE name = :name AND password = :password");
        //设置条件
        query.setProperties(users);
        Object user = query.uniqueResult();
        return user == null ? null : (Users) user;
    }

    public List<Users> findAllUser() {
        return getSession().createQuery("FROM Users").list();
    }

    public int getUser(String name) {
        return ((Long)getSession().createQuery("SELECT COUNT(id) FROM Users WHERE name = :name").setParameter("name",name).uniqueResult()).intValue();
    }


}
