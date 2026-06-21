package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "renttype")
public class RentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "rentTypes", fetch = FetchType.LAZY)
    private List<BuildingEntity>buildings = new ArrayList<>();

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }

    //    @OneToMany(mappedBy="rentType", fetch= FetchType.LAZY)
//    private List<BuildingRentTypeEntity> buildingRentTies = new ArrayList<>();
    // Bắt buộc phải tạo Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<BuildingRentTypeEntity> getBuildingRentTies() {
//        return buildingRentTies;
//    }
//
//    public void setBuildingRentTies(List<BuildingRentTypeEntity> buildingRentTies) {
//        this.buildingRentTies = buildingRentTies;
//    }
}
