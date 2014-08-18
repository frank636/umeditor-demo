package com.frank.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证图片工具类
 * <p>Title: ImageJudgeUtil.java</p>
 * <p>Company: changyou</p>
 * @author zhanghongli
 * @date 2014-7-17
 * @version 1.0
 */
public class ImageJudgeUtil {

	private static Logger log = LoggerFactory.getLogger(ImageJudgeUtil.class);
	
	/**
	 * 利用图片的宽和高判断图片
	 * @param stream 图片文件流
	 * @return true or false
	 */
	public static boolean isImage(InputStream stream) {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(stream);
			int imageHeight = bufferedImage.getHeight();
			int imageWidth = bufferedImage.getWidth();
			if(0 != imageHeight && 0 != imageWidth) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("ImageJudgeUtil，图片判断过程吃现异常，异常为：" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	/**
	 * 判断文件大小是否符合制定的大小要求
	 * <P>Title: judgeImageSize</p>
	 * @param file 文件
	 * @param size 制定的文件大小，单位：Byte
	 * @return
	 */
	public static boolean judgeImageSize(File file, long size) {
		
		if(null != file) {
			long length = file.length();
			if(0l != length && length <= size) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
