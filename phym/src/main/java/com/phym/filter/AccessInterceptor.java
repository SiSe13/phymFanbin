package com.phym.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.phym.entity.User;

@Component("accessInterceptor")
public class AccessInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		//������
		//��ѯsession���Ƿ񱣴��˵�¼�û���Ϣ
		//���û�е�¼ ����һ��JSON����������Ҫ��¼����Ϣ
		//����Ѿ���¼����ͨ�� ���� true
		User user=(User)req.getSession().getAttribute("user");
		
		System.out.println("user:"+user);
		
		if(user==null){
			String json=
				"{\"state\":1,\"message\":\"��Ҫ��¼\"}";
			res.setContentType("text/html; charset=utf-8");
			res.getWriter().print(json);
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
