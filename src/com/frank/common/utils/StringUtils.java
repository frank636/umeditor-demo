package com.frank.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class StringUtils {
	/**
	 * 判断字符串是否为空（""也为空）
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return str == null || "".equals(str);
	}
	
	/**
	 * 返回一个类的字符串，如果为空，则输出""，如果不为空，输入其toString()
	 * @param ob 类
	 * @return 字符串
	 */
	public static String null2String(Object ob) {
		if(ob == null) {
			return "";
		} else {
			return ob.toString();
		}
	}
	
	/**
	 * 字符串转成int
	 * @param src  要转成int的字符串
	 * @param dafautValue  默认值
	 * @return int
	 */
	public static Integer str2Int(String src, Integer dafautValue) {
		
		Integer result = dafautValue;
		try {
			result = Integer.valueOf(src);
		} catch (Exception e) {
			result = dafautValue;
		}
		
		return result;
	}
	
	
	/**
	 * 检测字符串是否是数字字符串
	 * @param src
	 * @return
	 */
	public static boolean checkDigit(String src) {
		return Pattern.matches("^[0-9]+$", src) ? true : false;
	}
	
	/**
	 * 检测字符串是否是数字
	 * @param src
	 * @return
	 */
	public static boolean checkNumber(String src) {
		return Pattern.matches("^[0-9.]+$", src) ? true : false;
	}
	
	/**
	 * 检测字符串是不是邮箱格式
	 * @param src
	 * @return
	 */
	public static boolean checkEmail(String src) {
		return Pattern.matches("^(\\w+((-\\w+)|(\\.\\w+))*)+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$", src);
	}
	
	/**
	 * 检测字符串是不是手机格式
	 * @param src
	 * @return
	 */
	public static boolean checkPhone(String src) {
		return Pattern.matches("^((13)|(14)|(15)|(17)|(18))[0-9]\\d{8}$", src);
	} 
	
	/**
	 * 检测字符串是不是手机格式
	 * @param src
	 * @return
	 */
	public static boolean checkPhonePlus(String src) {
		return Pattern.matches("^((13)|(14)|(15)|(17)|(18))[0-9]\\d{8}$", src)  || Pattern.matches("^[0-9]{1,8}-\\d{1,12}$", src);
	} 
	
	
	/**
	 * 检测字符串是不由字母和数字组成
	 * @param src
	 * @return
	 */
	public static boolean checkLetterAndNum(String src) {
		return Pattern.matches("^[A-Za-z0-9]+$", src);
	}
	
	
	/**
	 * 获取字符串的长度（中文算两个，英文算一个）
	 * @param src
	 * @return
	 */
	public static Integer getLength(String src) {
		try {
			byte[] b = src.getBytes("gb2312");
			return b.length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 根据字符长度截取字符串<br/>
	 * 如：getLimitLengthString("哈哈哈", 4) = '哈哈'
	 * @param str
	 * @param len
	 * @return
	 */
	public static String getLimitLengthString(String str, int len) {
		try {
			int counterOfDoubleByte = 0;
			byte[] b = str.getBytes("gb2312");
			if (b.length <= len)
				return str;
			for (int i = 0; i < len; i++) {
				if (b[i] < 0) {
					counterOfDoubleByte++;
				}
			}
			if (counterOfDoubleByte % 2 == 0)
				return new String(b, 0, len, "gb2312");
			else
				return new String(b, 0, len - 1, "gb2312");
		} catch (Exception ex) {
			return "";
		}
	}
	
	
	/**
	 * 判断字符串是否是证件格式(7-18位，只含有字母和数字)
	 * @param src
	 * @return
	 */
	public static boolean checkCertNumber(String src) {
		if(src != null || !"".equals(src)) {
			if(src.length() > 6 && src.length() < 19) {
				if(checkLetterAndNum(src)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * 将数组按照separator拼接成字符串,默认的separator 是','
	 * @param values 数组
	 * @param separator 拼接符
	 * @return 数组按照separator拼接成的字符串
	 */
	public static String array2String(Object[] values, String separator) {
		if(values == null || values.length <= 0) {
			return "";
		}
		separator = separator == null ? "," : separator;
		
		StringBuffer sb = new StringBuffer();
		
		for(Object o : values) {
			sb.append(null2String(o)).append(separator);
		}
		
		if(sb.length() > 0) {
			return sb.substring(0, sb.lastIndexOf(separator));
		}
		return sb.toString();
	}
	
	
	public static boolean isNotBlank(String src) {
		if(src == null || "".equals(src)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isBlank(String src) {
		if(src == null || "".equals(src)) {
			return true;
		}
		
		return false;
	}
 	
	
}
