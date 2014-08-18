package com.frank.common.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.frank.common.utils.StringUtils;

public class BaseController {
	
	private Map<String, Object> params;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParams(HttpServletRequest request) {
		Enumeration paramNames = request.getParameterNames();
		String key = null;
		String value = null;
		params = new HashMap<String, Object>();
		while(paramNames.hasMoreElements()) {
			key = (String)paramNames.nextElement();
			value = StringUtils.null2String(request.getParameter(key)).trim();
			params.put(key, value);
		}
		
		return params;
	}
	
	/**
	 * 
	 * @param extraParam
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public String getSuccessJsonString(Map extraParam) {
		JSONObject json = extraParam == null ? new JSONObject() : JSONObject.fromObject(extraParam);
		json.put("success", 0);
		return json.toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getErrorJsonString(Object errCode, Map extraParam) {
		JSONObject json = extraParam == null ? new JSONObject() : JSONObject.fromObject(extraParam);
		json.put("success", 1);
		json.put("errorCode", errCode);
		return json.toString();
	}
	
}
