package com.phym.service;

import org.junit.Test;

import com.phym.entity.User;

public class UserServiceTest extends TestBase{
	
	@Test
	public void test1() {
		
		String name = "tom";
		String password = "123456";
		
		User user = service.GGlogin(name, password);
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		String name = "miss";
		String password = "123456a";
		
		User user = service.MTlogin(name, password);
		System.out.println(user);
	}
	
	@Test
	public void test3() {
		
	}
	
}
