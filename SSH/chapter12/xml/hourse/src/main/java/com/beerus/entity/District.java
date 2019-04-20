package com.beerus.entity;

import java.util.Set;

/**
 * 区县表
 */
public class District {

    private Integer id;
    private String name;
    private Set<Street> datas;

    public District() {
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

    public District(Integer id) {
        this.id = id;
    }

    public Set<Street> getDatas() {
        return datas;
    }

    public void setDatas(Set<Street> datas) {
        this.datas = datas;
    }
}
