package com.beerus.entity;


import javax.persistence.*;
import java.util.Date;

/**
 *报销单审核结果
 */
@Entity
@Table(name = "BIZ_CHECK_RESULT")
public class BizCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "CLAIM_ID")
    private BizClaimVoucher bizClaimVoucher;
    @Column(name = "CHECK_TIME")
    private Date checkTime;
    @ManyToOne
    @JoinColumn(name = "CHECKER_SN")
    private SysEmployee checkerSn;
    @Column(name = "RESULT")
    private String result;
    @Column(name = "COMM")
    private String comm;

    public BizCheckResult() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BizClaimVoucher getBizClaimVoucher() {
        return bizClaimVoucher;
    }

    public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
        this.bizClaimVoucher = bizClaimVoucher;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public SysEmployee getCheckerSn() {
        return checkerSn;
    }

    public void setCheckerSn(SysEmployee checkerSn) {
        this.checkerSn = checkerSn;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }
}
