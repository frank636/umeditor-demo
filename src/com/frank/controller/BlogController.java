package com.frank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frank.common.controller.BaseController;
import com.frank.common.utils.StringUtils;
import com.frank.model.BlogDao;
import com.frank.model.entity.Blog;

@Controller
public class BlogController extends BaseController {

	@Autowired
	private @Getter @Setter BlogDao blogDao;
	
	
	@RequestMapping("blog/saveblog.do")
	@ResponseBody
	public String saveBlog(HttpServletRequest request, HttpServletResponse response) {
		String id = StringUtils.null2String(request.getParameter("id")).trim();
		
		String title = StringUtils.null2String(request.getParameter("title")).trim();
		String content = StringUtils.null2String(request.getParameter("content")).trim();
		
		String ip = request.getRemoteAddr();
		
		blogDao.saveBlog(title, content, ip);
		
		return this.getSuccessJsonString(null);
	}
	
	
	@RequestMapping("blog/getblog.do")
	public String getBlog(HttpServletRequest request, HttpServletResponse response) {
		String id = StringUtils.null2String(request.getParameter("id")).trim();
		
		
		String ip = request.getRemoteAddr();
		
		Blog blog = blogDao.getBlog(Long.valueOf(id));
		
		
		request.setAttribute("blog", blog);
		
		return "blog";
	}
	
}
