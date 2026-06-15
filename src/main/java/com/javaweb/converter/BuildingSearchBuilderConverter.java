package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params, List<String>typeCode) {
        BuildingSearchBuilder buildingSearchBuilder= new BuildingSearchBuilder.Builder()
                .setId(MapUtils.getObject(params, "id", String.class))
                .setName(MapUtils.getObject(params, "name", String.class))
                .setStreet(MapUtils.getObject(params, "street", String.class))
                .setWard(MapUtils.getObject(params, "ward", String.class))
                .setNumberOfBasement(MapUtils.getObject(params, "numberOfBasement", String.class))
                .setDirection(MapUtils.getObject(params, "direction", String.class))
                .setLevel(MapUtils.getObject(params, "level", String.class))
                .setTypeCode(typeCode)
                .setAreaTo(MapUtils.getObject(params, "areaTo", String.class))
                .setAreaFrom(MapUtils.getObject(params, "areaFrom", String.class))
                .setServiceFee(MapUtils.getObject(params, "serviceFee", String.class))
                .setCarfee(MapUtils.getObject(params, "carfee", String.class))
                .setMotorBikeFee(MapUtils.getObject(params, "motorBikeFee", String.class))
                .setOverTimeFee(MapUtils.getObject(params, "overTimeFee", String.class))
                .setWaterFee(MapUtils.getObject(params, "waterFee", String.class))
                .setElectricityFee(MapUtils.getObject(params, "electricityFee", String.class))
                .setDeposit(MapUtils.getObject(params, "deposit", String.class))
                .setPayment(MapUtils.getObject(params, "payment", String.class))
                .setRentTime(MapUtils.getObject(params, "rentTime", String.class))
                .setDecorationTime(MapUtils.getObject(params, "decorationTime", String.class))
                .setBrokerAgeFee(MapUtils.getObject(params, "brokerAgeFee", String.class))
                .setNote(MapUtils.getObject(params, "note", String.class))
                .setLinkOfBuilding(MapUtils.getObject(params, "linkOfBuilding", String.class))
                .setMap(MapUtils.getObject(params, "map", String.class))
                .setImage(MapUtils.getObject(params, "image", String.class))
                .setCreateDate(MapUtils.getObject(params, "createDate", String.class))
                .setModifiedBy(MapUtils.getObject(params, "modifiedBy", String.class))
                .setManagerName(MapUtils.getObject(params, "managerName", String.class))
                .setManagerPhoneNumber(MapUtils.getObject(params, "managerPhoneNumber", String.class))
                .setDistrict(MapUtils.getObject(params, "districtId", String.class))
                .setFloorArea(MapUtils.getObject(params, "floorArea", String.class))
                .setRentPriceTo(MapUtils.getObject(params, "rentPriceTo", String.class))
                .setRentPriceFrom(MapUtils.getObject(params, "rentPriceFrom", String.class))
                .setBrokerageFee(MapUtils.getObject(params, "brokerageFee", String.class))
                .setStaffId(MapUtils.getObject(params, "staffId", String.class))
                .build();

        return buildingSearchBuilder;
    }
}

