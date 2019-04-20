package com.beerus.entity;


import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单信息
 */
@Entity
@Table(name = "SALE_ORDER")
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ODR_ID")
    @JSONField(serialize=false)
    private Integer odrId;
    @ManyToOne
    @JoinColumn(name = "ODR_CUSTOMER_ID")
    @JSONField(serialize=false)
    private CusCustomer cusCustomer;
    @Column(name = "ODR_CUSTOMER_NAME")
    @JSONField(serialize=false)
    private String odrCustomerName;
    @Column(name = "ODR_DELIVER_ADDR")
    @JSONField(serialize=false)
    private String odrDeliverAddr;
    @Column(name = "ODR_ORDER_DATE")
    @JSONField(serialize=false)
    private Date odrOrderDate;
    @Column(name = "ODR_DELIVER_DATE")
    @JSONField(serialize=false)
    private Date odrDeliverDate;
    @Column(name = "ODR_STATUS")
    @JSONField(serialize=false)
    private String odrStatus;
    @OneToMany(targetEntity = SaleOrderLine.class)
    @JoinColumn(name = "ODL_ORDER_ID")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<SaleOrderLine> saleOrderLines = new HashSet<SaleOrderLine>();

    public SaleOrder() {
    }

    public Set<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(Set<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    public Integer getOdrId() {
        return odrId;
    }

    public void setOdrId(Integer odrId) {
        this.odrId = odrId;
    }

    public CusCustomer getCusCustomer() {
        return cusCustomer;
    }

    public void setCusCustomer(CusCustomer cusCustomer) {
        this.cusCustomer = cusCustomer;
    }

    public String getOdrCustomerName() {
        return odrCustomerName;
    }

    public void setOdrCustomerName(String odrCustomerName) {
        this.odrCustomerName = odrCustomerName;
    }

    public String getOdrDeliverAddr() {
        return odrDeliverAddr;
    }

    public void setOdrDeliverAddr(String odrDeliverAddr) {
        this.odrDeliverAddr = odrDeliverAddr;
    }

    public Date getOdrOrderDate() {
        return odrOrderDate;
    }

    public void setOdrOrderDate(Date odrOrderDate) {
        this.odrOrderDate = odrOrderDate;
    }

    public Date getOdrDeliverDate() {
        return odrDeliverDate;
    }

    public void setOdrDeliverDate(Date odrDeliverDate) {
        this.odrDeliverDate = odrDeliverDate;
    }

    public String getOdrStatus() {
        return odrStatus;
    }

    public void setOdrStatus(String odrStatus) {
        this.odrStatus = odrStatus;
    }
}
