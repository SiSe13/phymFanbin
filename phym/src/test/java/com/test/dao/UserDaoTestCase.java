package com.test.dao;

import org.junit.Before;
import org.junit.Test;

import com.phym.dao.UserDao;
import com.phym.entity.User;
import com.test.BaseTest;


public class UserDaoTestCase extends BaseTest {
	UserDao dao;
	
	@Before
	public void initDao(){
		dao =ctx.getBean("userDao",UserDao.class);
	}
	
	@Test
	public void testfindUserByName(){
		String name="tom";
		
		
		User user= dao.findUserByName(name);
		System.out.println(user);
	}
	
	@Test
	public void test1(){
		String id="123456";
		String userId="05f6da9757464e98a6f4758004ffba8f";
		int n=dao.insertUserInfo(id, userId);
		System.out.println(n);
	}

	
	
	
	
	
}
