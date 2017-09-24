package com.test.service;

import org.junit.Before;
import org.junit.Test;

import com.phym.entity.User;
import com.phym.service.UserService;
import com.test.BaseTest;

public class UserServiceTest extends BaseTest {
	UserService us;
	
	@Before
	public void initService(){
		
		us=ctx.getBean("userService",UserService.class);
	}
	
	@Test
	public void TestRegist(){
		User user =us.regist("dfek", "13332602514", "123", "123",1);
		System.out.println(user);
	}
	

}
