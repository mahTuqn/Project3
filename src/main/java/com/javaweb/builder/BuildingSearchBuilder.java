package com.javaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {
    private String id;
    private String name;
    private String street;
    private String ward;
    private String numberOfBasement;
    private String direction;
    private String level;
    private String areaTo;
    private String areaFrom;
    private String serviceFee;
    private String carfee;
    private String motorBikeFee;
    private String overTimeFee;
    private String waterFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private String brokerAgeFee;
    private String note;
    private String linkOfBuilding;
    private String map;
    private String image;
    private String createDate;
    private String modifiedBy;
    private String managerName;
    private String managerPhoneNumber;
    private String districtId;
    private String floorArea;
    private String rentPriceTo;
    private String rentPriceFrom;
    private String brokerageFee;
    private List<String> typeCode;
    private String staffId;

    private BuildingSearchBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.street = builder.street;
        this.ward = builder.ward;
        this.numberOfBasement = builder.numberOfBasement;
        this.direction = builder.direction;
        this.level = builder.level;
        this.areaTo = builder.areaTo;
        this.areaFrom=builder.areaFrom;
        this.serviceFee = builder.serviceFee;
        this.carfee = builder.carfee;
        this.motorBikeFee = builder.motorBikeFee;
        this.overTimeFee = builder.overTimeFee;
        this.waterFee = builder.waterFee;
        this.electricityFee = builder.electricityFee;
        this.deposit = builder.deposit;
        this.payment = builder.payment;
        this.rentTime = builder.rentTime;
        this.decorationTime = builder.decorationTime;
        this.brokerAgeFee = builder.brokerAgeFee;
        this.note = builder.note;
        this.linkOfBuilding = builder.linkOfBuilding;
        this.map = builder.map;
        this.image = builder.image;
        this.createDate = builder.createDate;
        this.modifiedBy = builder.modifiedBy;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.districtId = builder.districtId;
        this.floorArea = builder.floorArea;
        this.rentPriceTo = builder.rentPriceTo;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.brokerageFee = builder.brokerageFee;
        this.typeCode = builder.typeCode;
        this.staffId = builder.staffId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public String getAreaTo() {
        return areaTo;
    }

    public String getAreaFrom() {
        return areaFrom;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public String getCarfee() {
        return carfee;
    }

    public String getMotorBikeFee() {
        return motorBikeFee;
    }

    public String getOverTimeFee() {
        return overTimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getPayment() {
        return payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public String getBrokerAgeFee() {
        return brokerAgeFee;
    }

    public String getNote() {
        return note;
    }

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public String getImage() {
        return image;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public String getDistrictId() {
        return districtId;
    }

    public String getFloorArea() {
        return floorArea;
    }

    public String getRentPriceTo() {
        return rentPriceTo;
    }

    public String getRentPriceFrom() {
        return rentPriceFrom;
    }

    public String getBrokerageFee() {
        return brokerageFee;
    }

    public static class Builder {
        private String id;
        private String name;
        private String street;
        private String ward;
        private String numberOfBasement;
        private String direction;
        private String level;
        private String areaTo;
        private String areaFrom;
        private String serviceFee;
        private String carfee;
        private String motorBikeFee;
        private String overTimeFee;
        private String waterFee;
        private String electricityFee;
        private String deposit;
        private String payment;
        private String rentTime;
        private String decorationTime;
        private String brokerAgeFee;
        private String note;
        private String linkOfBuilding;
        private String map;
        private String image;
        private String createDate;
        private String modifiedBy;
        private String managerName;
        private String managerPhoneNumber;
        private String districtId;
        private String floorArea;
        private String rentPriceTo;
        private String rentPriceFrom;
        private String brokerageFee;
        private List<String> typeCode;
        private String staffId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setNumberOfBasement(String numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setAreaTo(String areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public Builder setAreaFrom(String areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public Builder setServiceFee(String serviceFee) {
            this.serviceFee = serviceFee;
            return this;
        }

        public Builder setCarfee(String carfee) {
            this.carfee = carfee;
            return this;
        }

        public Builder setMotorBikeFee(String motorBikeFee) {
            this.motorBikeFee = motorBikeFee;
            return this;
        }

        public Builder setOverTimeFee(String overTimeFee) {
            this.overTimeFee = overTimeFee;
            return this;
        }

        public Builder setWaterFee(String waterFee) {
            this.waterFee = waterFee;
            return this;
        }

        public Builder setElectricityFee(String electricityFee) {
            this.electricityFee = electricityFee;
            return this;
        }

        public Builder setDeposit(String deposit) {
            this.deposit = deposit;
            return this;
        }

        public Builder setPayment(String payment) {
            this.payment = payment;
            return this;
        }

        public Builder setRentTime(String rentTime) {
            this.rentTime = rentTime;
            return this;
        }

        public Builder setDecorationTime(String decorationTime) {
            this.decorationTime = decorationTime;
            return this;
        }

        public Builder setBrokerAgeFee(String brokerAgeFee) {
            this.brokerAgeFee = brokerAgeFee;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public Builder setLinkOfBuilding(String linkOfBuilding) {
            this.linkOfBuilding = linkOfBuilding;
            return this;
        }

        public Builder setMap(String map) {
            this.map = map;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }

        public Builder setDistrict(String districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder setFloorArea(String floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setRentPriceTo(String rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder setRentPriceFrom(String rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setBrokerageFee(String brokerageFee) {
            this.brokerageFee = brokerageFee;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public Builder setStaffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}

