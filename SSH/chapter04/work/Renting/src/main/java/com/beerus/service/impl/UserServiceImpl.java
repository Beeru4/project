package com.beerus.service.impl;


import com.beerus.dao.impl.UserDaoImpl;
import com.beerus.entity.Users;
import com.beerus.service.UserService;
import org.hibernate.Transaction;

import java.io.Serializable;

public class UserServiceImpl implements UserService {
    UserDaoImpl dao = new UserDaoImpl();

    public void addUser(Users user) {
        Transaction tx = null;
        try {
            //开启事务
            tx = UserDaoImpl.getSession().beginTransaction();
            dao.addUser(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常 回滚事务
            tx.rollback();
        }
    }

    public void update(Users user) {
        Transaction tx = null;
        try {
            tx = UserDaoImpl.getSession().beginTransaction();
            dao.update(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }

    }

    public void delete(Users user) {
        Transaction tx = null;
        try {
            tx = UserDaoImpl.getSession().beginTransaction();
            dao.delete(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public Users query(Class clzz, Serializable id) {
        Transaction tx = null;
        Users users = null;
        try {
            tx = UserDaoImpl.getSession().beginTransaction();
            users = dao.query(clzz, id);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return users;
    }
}
