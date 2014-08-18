package com.frank.common.utils;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
/**
 * 接口签名工具
 * @author WangXin 2014-4-26
 * @version 1.0
 *
 */
public class SignUtils {

	public static String CONNECTOR = "&";

	public static String SIGN_DATE_KEY = "date";
	
	public static String SIGN_KEY = "sign";
	
	public static String CHARSET_KEY = "charset";

	public static SimpleDateFormat SIGN_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

	public static SimpleDateFormat PARAM_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 对参数进行签名
	 * @param appkey 应用标示（通信公钥）
	 * @param paramMap	请求参数
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String sign(String appkey, Map<String, Object> paramMap) throws UnsupportedEncodingException {
		// 加入请求时间参数
		if(paramMap.get(SIGN_DATE_KEY) == null) {
			paramMap.put(SIGN_DATE_KEY, (SIGN_DATE_FORMAT.format(new Date())));
		}
		//将参数排序
		String signStr = paramSortStr(paramMap);
		// 拼接上appKey转换为MD5
		String sign = DigestUtils.md5Hex(signStr + appkey);
		//将签名放置在Map中以便直接发送请求
		paramMap.put(SIGN_KEY, sign);
		return sign;
	}
	
	public static boolean verify(String appkey, Integer timeout, Map<String, Object> paramMap) {
		//移除jquery防缓存参数
		try {
			if(paramMap.get("_") != null) {
				paramMap.remove("_");
			}
			//判断请求参数是否超时
			if(timeout != null) {
				long signTime = (SIGN_DATE_FORMAT.parse((String) paramMap.get(SIGN_DATE_KEY))).getTime();
				if(((new Date().getTime())/1000*1000) > (signTime + timeout*1000)) {
					return false;
				}
			}
			String signStr = paramSortStr(paramMap);
			String sign = DigestUtils.md5Hex(signStr + appkey);
			return sign.equals(paramMap.get(SIGN_KEY));
		} catch (Exception e) {
			
		}
		return false;
	}
	
	/**
	 * 参数排序
	 * @param paramMap
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String paramSortStr(Map<String, Object> paramMap) throws UnsupportedEncodingException {
		// 排序所有参数
		List<String> paramList = new ArrayList<String>();
		String charset = (String) paramMap.get(CHARSET_KEY);
		for (String key : paramMap.keySet()) {
			//判断如果是签名参数则跳过
			if(!SIGN_KEY.equals(key)) {
				Object val = paramMap.get(key);
				//如果是日期类型，进行格式化
				if (val instanceof Date && val != null) {
					val = PARAM_DATE_FORMAT.format(val);
				}
				if(StringUtils.isNotBlank(charset)) {
					val = new String((val != null ? val.toString() : "").getBytes(charset), "UTF-8"); 
				}
				paramList.add(key + "=" + (val != null ? val.toString() : ""));
			}
		}
		// 对参数进行字典排序 忽略大小写按字母顺序
		Collections.sort(paramList, String.CASE_INSENSITIVE_ORDER);
		// 拼接所有参数
		StringBuilder signStr = new StringBuilder();
		for (String paramStr : paramList) {
			if (signStr.length() > 0)
				signStr.append(CONNECTOR);
			signStr.append(paramStr);
		}
		return signStr.toString();
	}
	
	

	public static void main(String[] args) throws ParseException, InterruptedException, UnsupportedEncodingException {
		String password = "101010";
		PBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
	    encryptor.setPassword("jesong");
	    String encPassword = encryptor.encrypt(password);
	    System.out.println(encPassword);
	}
	
	

}
