package com.beerus.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * @Author Beerus
 * @Description 用户Bean
 * @Date 2019-05-09
 **/
public class User implements Serializable {
    private String userName;
    private Double age;
    private Date birthday;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
