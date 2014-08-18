package com.frank.common.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求request中的请求路径以及参数的完整链接
 * <p>Title: TiaoZhuanParamUtil.java</p>
 * <p>Company: changyou</p>
 * @author zhanghongli
 * @date 2014-7-30
 * @version 1.0
 */
public class CompleteRequestUrlUtil {

	@SuppressWarnings("unchecked")
	public static String getCompleteRequestUrl(HttpServletRequest request) {
		
		String completeRequestUrl = null;
		
		if(null == request) {
			return completeRequestUrl;
		}
		
		StringBuffer requestUrl = request.getRequestURL();
		Enumeration<String> enumeration = request.getParameterNames();
		if(null == enumeration) {
			completeRequestUrl = requestUrl.toString();
		} else {
			StringBuffer params = new StringBuffer();
			while(enumeration.hasMoreElements()) {
				String element = enumeration.nextElement();
				String value = request.getParameter(element);
				params.append(element).append("=").append(value).append("&");
			}
			if(params.length() <= 0) {
				completeRequestUrl = requestUrl.toString();
			} else {
				completeRequestUrl = requestUrl.append("?").append(params.substring(0, params.length() - 1)).toString();
			}			
		}
		
		return completeRequestUrl;
	}
	
}
