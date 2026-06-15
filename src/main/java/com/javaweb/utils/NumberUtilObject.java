package com.javaweb.utils;

public class NumberUtilObject {
    public static boolean isNumber(Object value) {
        if (value == null) return false;
        try {
            Long.parseLong(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
