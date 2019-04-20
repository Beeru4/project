package com.beerus.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 房屋信息
 */
@Entity
@Table(name = "HOUSE")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "PUBDATE")
    private Date pubdate;
    @Column(name = "FLOORAGE")
    private Integer floorage;
    @Column(name = "CONTACT")
    private String contact;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "STREET_ID")
    private Street street;
    //房屋位置
    @Transient
    private Integer postion;
    @Column(name = "house_image")
    private String house_image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Integer getPostion() {
        return postion;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    public String getHouse_image() {
        return house_image;
    }

    public void setHouse_image(String house_image) {
        this.house_image = house_image;
    }

    public House() {
    }

}
