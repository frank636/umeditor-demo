package com.frank.common.utils;

import net.sf.json.JSONObject;

public class JSONUtils {
	
	public static Object getValue(String key, JSONObject json) {
		if(key != null && json != null) {
			try {
				return json.get(key);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	} 
	
	public static String getString(String key, JSONObject json) {
		if(key != null && json != null) {
			try {
				return json.getString(key);
			} catch (Exception e) {
				return "";
			}
		}
		return "";
	} 
	
	public static Integer getInt(String key, JSONObject json) {
		if(key != null && json != null) {
			try {
				return Integer.valueOf(json.getString(key));
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	} 
	
	
	
	
}
