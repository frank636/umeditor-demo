package com.frank.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * @author lixiangyang
 *
 */
public class UrlUtils {
	private static Logger log = LoggerFactory.getLogger("UrlUtils");
	
	/**
	 * 读取url
	 * @param urlStr 
	 * @param connectionTimeOut
	 * @param readTimeOut
	 * @return  string
	 */
	public static String getResultFromUrl(String urlStr, Integer connectionTimeOut, Integer readTimeOut) {
		StringBuffer sb = new StringBuffer();
		
		URL url = null;
		HttpURLConnection connection = null;
		InputStream in = null;
		BufferedReader br = null;
		
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setUseCaches(false);
			connection.setConnectTimeout(connectionTimeOut);
			connection.setReadTimeout(readTimeOut);
			
			in = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (MalformedURLException e) {
			log.error("url:{} 连接异常:{}", urlStr, e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("url:{} 读取异常:{}", urlStr, e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.error("url:{} 异常:{}", urlStr, e.getMessage());
			e.printStackTrace();
		} finally {
			StreamUtils.close(br);
			StreamUtils.close(in);
		}
		
		return sb.toString();
	}
	
	
	public static String params2String(Map map) {
		StringBuffer sb = new StringBuffer();
		if(map != null && map.size() > 0) {
			for(Object key : map.keySet()) {
				sb.append("&").append(key.toString()).append("=").append(URLEncoder.encode(StringUtils.null2String(map.get(key))));
			}
			sb.subSequence(1, sb.length());
		}
		
		return sb.toString();
	}
	
}
