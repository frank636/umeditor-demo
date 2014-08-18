package com.frank.common.utils;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class PropertyUtils {
	private static Properties properties;
	
	static {
		try {
			ClassPathResource resource = new ClassPathResource("app.properties");
			properties = new Properties();
			properties.load(resource.getInputStream());
			
		} catch (Exception e) {
			System.out.println("加载app.properties出错:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static String getValue(String key) {
		if(properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return "";
	}
	
}
