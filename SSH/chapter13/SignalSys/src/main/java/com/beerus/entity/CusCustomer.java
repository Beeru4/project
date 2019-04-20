package com.beerus.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 客户信息表
 */
@Entity
@Table(name = "CUS_CUSTOMER")
public class CusCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUS_ID")
    private Integer cusId;
    @Column(name = "CUS_NAME")
    private String cusName;
    @Column(name = "CUS_ADDR")
    private String cusAddr;
    @OneToMany
    @JoinColumn(name = "ODR_CUSTOMER_ID")
    private Set<SaleOrder> orders;

    public CusCustomer() {
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public Set<SaleOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<SaleOrder> orders) {
        this.orders = orders;
    }
}
