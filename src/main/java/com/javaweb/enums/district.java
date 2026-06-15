package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum district {
    Q1("Quận 1"),
    Q2("Quận 2"),
    Q4("Quận 4");

    private final String districtName;

    district(String districtName) {
        this.districtName=districtName;
    }

    public static Map<String,String> type() {
        Map<String,String> districts=new TreeMap<>();
        for(district it: district.values()) {
            districts.put(it.toString(), it.districtName);
        }
        return districts;
    }
}
