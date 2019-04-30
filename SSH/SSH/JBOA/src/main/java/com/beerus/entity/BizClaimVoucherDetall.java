package com.beerus.entity;

import javax.persistence.*;

/**
 * 报销单明细
 */
@Entity
@Table(name = "BIZ_CLAIM_VOUCHER_DETALL")
public class BizClaimVoucherDetall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "MAIN_ID")
    private BizClaimVoucher claimVoucher;
    @Column(name = "ITEM")
    private String item;
    @Column(name = "ACCOUNT")
    private Integer account;
    @Column(name = "DES")
    private String des;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BizClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(BizClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
