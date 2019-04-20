package com.beerus.entity;

import javax.persistence.*;

/**
 * 产品信息
 */
@Entity
@Table(name = "SALE_PRODUCT")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Integer prodId;
    @Column(name = "PROD_NAME")
    private String prodName;
    @Column(name = "PROD_PRICE")
    private Integer prodPrice;


    public SaleProduct() {
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Integer prodPrice) {
        this.prodPrice = prodPrice;
    }
}
