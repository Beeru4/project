package com.beerus.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

/**
 * 订单明细
 */
@Entity
@Table(name = "SALE_ORDER_LINE")
public class SaleOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ODL_ID")
    @JSONField(serialize=false)
    private Integer odlId;
    @ManyToOne
    @JoinColumn(name = "ODL_ORDER_ID")
    @JSONField(serialize=false)
    private SaleOrder saleOrder;
    @Column(name = "ODL_PRODUCT_NAME")
    private String odlProductName;
    @Column(name = "ODL_PRODUCT_PRICE")
    private Integer odlProductPrice;
    @Column(name = "ODL_PRODUCT_COUNT")
    private Integer odlProductCount;

    public SaleOrderLine() {
    }

    public Integer getOdlId() {
        return odlId;
    }

    public void setOdlId(Integer odlId) {
        this.odlId = odlId;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public String getOdlProductName() {
        return odlProductName;
    }

    public void setOdlProductName(String odlProductName) {
        this.odlProductName = odlProductName;
    }

    public Integer getOdlProductPrice() {
        return odlProductPrice;
    }

    public void setOdlProductPrice(Integer odlProductPrice) {
        this.odlProductPrice = odlProductPrice;
    }

    public Integer getOdlProductCount() {
        return odlProductCount;
    }

    public void setOdlProductCount(Integer odlProductCount) {
        this.odlProductCount = odlProductCount;
    }
}
