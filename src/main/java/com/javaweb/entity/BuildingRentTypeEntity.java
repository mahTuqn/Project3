package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name="buildingrenttype")
public class BuildingRentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="buildingid")
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name="renttypeid")
    private RentTypeEntity rentType;

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RentTypeEntity getRentType() {
        return rentType;
    }

    public void setRentType(RentTypeEntity rentType) {
        this.rentType = rentType;
    }
}
