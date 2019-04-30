package com.beerus.entity;

import javax.persistence.*;

/**
 * 部门表
 */
@Entity
@Table(name = "SYS_DEPARTMENT")
public class SysDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;

    public SysDepartment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
