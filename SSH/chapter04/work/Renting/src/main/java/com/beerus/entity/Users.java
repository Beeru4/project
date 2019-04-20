package com.beerus.entity;

/**
 * 用户表
 */
public class Users {

  private Integer id;
  private String name;
  private String password;
  private String telephone;
  private String username;
  private String isadmin;

  public Users(Integer id) {
    this.id = id;
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

}
