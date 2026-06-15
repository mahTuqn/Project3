package com.javaweb.utils;

public class StringUtilObject {
    public static boolean checkString(Object data) {
        return data != null && !data.toString().trim().isEmpty();
    }
}
