package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {

    DDX("Dan di xem nha"),
    CSKH("Cham soc khach hang");

    private final String name;

    TransactionType(String name) {
        this.name = name;
    }

    public String getCode() {
        return name;
    }

    public static Map<String,String> type() {
        Map<String,String> listType = new HashMap<>();
        for(TransactionType item : TransactionType.values()) {
            listType.put(item.toString(), item.name());
        }
        return listType;
    }

}
