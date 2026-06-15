package com.javaweb.utils;

import java.util.Map;

public class MapUtils {
	public static <T> T getObject(Map<String,Object> params, String key, Class<T> tClass) {
		Object obj= params.getOrDefault(key, null);
		if(obj != null) {
			if(tClass.getTypeName().contentEquals("java.lang.Long")) {
				if(obj != null) {
					obj=Long.valueOf(obj.toString());
				}
				else {
					obj=null;
				}
			}
			else if(tClass.getTypeName().contentEquals("java.lang.Integer")) {
				if(obj != null) {
					obj=Integer.valueOf(obj.toString());
				}
				else {
					obj=null;
				}
			}
			else if(tClass.getTypeName().contentEquals("java.lang.Long")) {
				if(obj != null) {
					obj=obj.toString();
				}
				else {
					obj=null;
				}
			}
			return tClass.cast(obj);
		}
		return null;
	}
}
