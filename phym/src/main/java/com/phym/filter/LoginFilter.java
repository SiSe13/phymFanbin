package com.phym.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phym.entity.User;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//过滤器
		//1. 获取登录用户信息
		//2. 如果没有登录用户信息，重定向到 log_in.html
		String path = request.getRequestURI();
		//System.out.println("path："+path);
		
		if(path.endsWith("login.html") ||path.endsWith("index.html")||path.endsWith("password.html")||path.endsWith("register.html")){ 
			//设置HTTP协议头，避免浏览器缓存html页面
			response.addHeader("Cache-Control", "no-cache");
			chain.doFilter(req, res);
			return;
		}
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			//如果user为null则表示没有登录
			//重定向到 log_in.html
			//采用绝对路径重定向！可以避免错误
			String login = 
					request.getContextPath()+ "/login.html";
			// /note/log_in.html
			response.sendRedirect(login);
			return;
		}
		//设置HTTP协议头，避免浏览器缓存html页面
		response.addHeader("Cache-Control", "no-cache");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
