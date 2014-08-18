package com.frank.common.utils;

/**
 * 常量类<br/><br/>
 * 各类常量用固定开头<br/><br/>
 * session常量用SESSION开头<br/>
 * properties常量用PROPERTIES开头<br/>
 * 
 * @author lixiangyang
 *
 */
public class Constants {

	
	public final static String SESSION_KEY_USERINFO                 = "userinfo";     //session 中存放userinfo的key

	public final static String PROPERTIES_KEY_LOGINURL              = "login.url";       //properties文件中登录url的key
	public final static String PROPERTIES_KEY_LOGIN_APPKEY          = "login.appkey";    //properties文件中登录appkey的key
	public final static String PROPERTIES_KEY_GETUSERINFOURL        = "getuserinfo.url";       //properties文件中获取账号信息的url的key
	public final static String PROPERTIES_KEY_FEEDBACK_EMAIL        = "feedback.email";  //properties文件中登录反馈邮箱的key
	public final static String PROPERTIES_KEY_LIVE800_URL           = "live800.url";     //properties文件中live800url的key
	public final static String PROPERTIES_KEY_LIVE800_COMPANYID     = "live800.companyId";    //properties文件中live800 companyid的key
	public final static String PROPERTIES_KEY_LIVE800_CONFIGID      = "live800.configId";    //properties文件中live800 configid的key
	public final static String PROPERTIES_KEY_LIVE800_POLICYID      = "live800.policyId";    //properties文件中live800 policyid的key
	public final static String PROPERTIES_KEY_LIVE800_ENTERURL      = "live800.enterUrl";    //properties文件中live800 enterUrl的key
	public final static String PROPERTIES_KEY_ATTACH_URL            = "attach.url";    //properties文件中上传附件url的key
	
	public final static String QUICK_CHANNEL_KEY					= "quick_channel_key";
	public final static String BBS_CHANNEL_KEY						= "bbs_channel_key";
	public final static String SELFSERVICE_KEY						= "selfservice_key";
	
	public final static String BASE_DICTIONARY_PROVINCE				= "base_dictionary_province";	//记录所有省份信息的key
	
	
}
