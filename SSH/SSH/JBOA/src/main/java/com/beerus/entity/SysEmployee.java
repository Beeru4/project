package com.beerus.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 员工表
 */
@Entity
@Table(name = "SYS_EMPLOYEE")
public class SysEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String sn;
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private SysPosition position;
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private SysDepartment department;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STATUS")
    private String status;
    @OneToMany
    /* @OneToMany(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "CREATE_SN")
    private Set<BizClaimVoucher> items = new HashSet<BizClaimVoucher>();

    public SysEmployee() {
    }

    public SysEmployee(String sn) {
        this.sn = sn;
    }

    public Set<BizClaimVoucher> getItems() {
        return items;
    }

    public void setItems(Set<BizClaimVoucher> items) {
        this.items = items;
    }

    public Set<BizClaimVoucher> getItem() {
        return items;
    }

    public void setItem(Set<BizClaimVoucher> items) {
        this.items = items;
    }

    public SysEmployee(String sn, String password) {
        this.sn = sn;
        this.password = password;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public SysPosition getPosition() {
        return position;
    }

    public void setPosition(SysPosition position) {
        this.position = position;
    }

    public SysDepartment getDepartment() {
        return department;
    }

    public void setDepartment(SysDepartment department) {
        this.department = department;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
