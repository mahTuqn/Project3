package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum TypeCode {

    tang_tret("Tang tret"),
    nguyen_can("Nguyen can"),
    noi_that("Noi that");

    private final String name;

    TypeCode(String name) {
        this.name=name;
    }
    public static Map<String,String> type() {
        Map<String, String> typdeCodes= new TreeMap<>();
        for(TypeCode it : TypeCode.values()) {
            typdeCodes.put(it.toString(), it.name);
        }
        return typdeCodes;
    }
}
