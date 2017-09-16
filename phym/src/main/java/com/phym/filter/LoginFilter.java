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
import javax.servlet.http.HttpSession;

import com.phym.entity.User;

public class LoginFilter implements Filter {

	public void destroy() {
		

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//������
		//1. ��ȡ��¼�û���Ϣ
		//2. ���û�е�¼�û���Ϣ���ض��� log_in.html
		String path = request.getRequestURI();
		System.out.println("path��"+path);
		
		if(path.endsWith("login.html") ||path.endsWith("password.html")||path.endsWith("register.html")){ 
				//����HTTPЭ��ͷ���������������htmlҳ��
				response.addHeader("Cache-Control", "no-cache");
				chain.doFilter(req, res);
				return;
			}
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			//���userΪnull���ʾû�е�¼
			//�ض��� log_in.html
			//���þ���·���ض��򣡿��Ա������
			String login = 
					request.getContextPath()+ 
				"/login.html";
			// /note/log_in.html
			response.sendRedirect(login);
			return;
		}
		
		
		//����HTTPЭ��ͷ���������������htmlҳ��
		response.addHeader("Cache-Control", "no-cache");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
