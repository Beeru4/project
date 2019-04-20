package com.beerus.service.impl;


import com.beerus.dao.impl.UserDaoImpl;
import com.beerus.entity.Users;
import com.beerus.service.UserService;
import com.beerus.utils.Mark;
import org.hibernate.HibernateException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl dao = new UserDaoImpl();

    public int register(Users user) {
        try {
            dao.saveUser(user);
            return Mark.SUCCESS_I;
        } catch (HibernateException e) {
            return Mark.ERROR_I;
        }
    }

    public Users login(Users user) {
        try {
            return dao.getByUser(user);
        } catch (HibernateException e) {
            return null;
        }
    }

    public List<Users> findAllUser() {
        return dao.findAllUser();
    }

    public boolean checkUserName(String name) {
        return dao.getUser(name) > Mark.ERROR_I;
    }

}
