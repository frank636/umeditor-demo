package com.frank.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * XSS过滤，将每个参数都进行过滤
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public String getQueryString() {
		return filter(super.getQueryString());
	}

	public String getParameter(String name) {
		return filter(super.getParameter(name));
	}

	public String[] getParameterValues(String name) {
		return filter(super.getParameterValues(name));
	}

	/**
	 * 过滤请求参数值
	 * 
	 * @param parameter
	 * @return
	 */
	private String filter(String parameter) {
		if (StringUtils.isBlank(parameter)) {
			return null;
		}
		return StringEscapeUtils.escapeSql(StringEscapeUtils.escapeJavaScript(StringEscapeUtils.escapeHtml(parameter)));
	}

	private String[] filter(String[] parameters) {
		if (parameters==null||parameters.length == 0) {
			return null;
		}
		for (int i = 0; i < parameters.length; i++) {
			parameters[i] = StringEscapeUtils.escapeSql(StringEscapeUtils.escapeJavaScript(StringEscapeUtils.escapeHtml(parameters[i])));
		}
		return parameters;
	}

}
