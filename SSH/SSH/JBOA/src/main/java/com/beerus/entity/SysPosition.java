package com.beerus.entity;

import javax.persistence.*;

/**
 * 职位表
 */
@Entity
@Table(name = "SYS_POSITION")
public class SysPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME_CN")
    private String nameCn;
    @Column(name = "NAME_EN")
    private String nameEn;


    public SysPosition() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
