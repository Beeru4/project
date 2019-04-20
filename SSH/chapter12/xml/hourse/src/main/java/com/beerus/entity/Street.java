package com.beerus.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 街道表
 */
@Entity
@Table(name = "STREET")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name = "DISTRICT_ID")
    private District district;
    @OneToMany(mappedBy = "street")
    private Set<House> houseSet;

    public Set<House> getHouseSet() {
        return houseSet;
    }

    public void setHouseSet(Set<House> houseSet) {
        this.houseSet = houseSet;
    }

    public Integer getId() {
        return id;
    }

    public Street() {
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district=" + district +
                '}';
    }
}
