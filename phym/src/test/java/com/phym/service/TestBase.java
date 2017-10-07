package com.phym.service;


import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.phym.dao.UserDao;

public class TestBase {
	UserService service;
	
	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userService",UserService.class);
	}
	
}
