package com.beerus.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 用户表
 */
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "ISADMIN")
    private String isadmin;
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private Set<House> houseSet;

    public Set<House> getHouseSet() {
        return houseSet;
    }

    public void setHouseSet(Set<House> houseSet) {
        this.houseSet = houseSet;
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", isadmin='" + isadmin + '\'' +
                '}';
    }
}
