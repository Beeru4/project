package com.beerus.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 报销单
 */
@Entity
@Table(name = "BIZ_CLAIM_VOUCHER")
public class BizClaimVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "NEXT_DEAL_SN")
    private SysEmployee nextDealSn;
    @ManyToOne
    @JoinColumn(name = "CREATE_SN")
    private SysEmployee createSn;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;
    @Column(name = "EVENT")
    private String event;
    @Column(name = "TOTAL_ACCOUNT")
    private Integer totalAccount;
    @Column(name = "STATUS")
    private String status;
    @OneToMany
    @JoinColumn(name = "MAIN_ID")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<BizClaimVoucherDetall> voucherDetalls = new HashSet<BizClaimVoucherDetall>();
    @OneToMany
    @JoinColumn(name = "CLAIM_ID")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<BizCheckResult> checkDetall = new HashSet<BizCheckResult>();
    //条件 不映射数据库字段
    @Transient
    private String sn;

    public BizClaimVoucher() {
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<BizCheckResult> getCheckDetall() {
        return checkDetall;
    }

    public void setCheckDetall(Set<BizCheckResult> checkDetall) {
        this.checkDetall = checkDetall;
    }

    public SysEmployee getNextDealSn() {
        return nextDealSn;
    }

    public void setNextDealSn(SysEmployee nextDealSn) {
        this.nextDealSn = nextDealSn;
    }

    public SysEmployee getCreateSn() {
        return createSn;
    }

    public void setCreateSn(SysEmployee createSn) {
        this.createSn = createSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(Integer totalAccount) {
        this.totalAccount = totalAccount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<BizClaimVoucherDetall> getVoucherDetalls() {
        return voucherDetalls;
    }

    public void setVoucherDetalls(Set<BizClaimVoucherDetall> voucherDetalls) {
        this.voucherDetalls = voucherDetalls;
    }
}
