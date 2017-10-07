package com.phym.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.phym.dao.UserDao;
import com.phym.entity.User;

public class UserDaoTest extends TestBase{
	
	
	
	
	
	
	@Test
	public void test1() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		String name = "tom";
		User user = dao.findUserByName(name);
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		String phone = "18931991234";
		User user = dao.findUserByPhone(phone);
		System.out.println(user);
		String newPwd = "123456";
		if(user != null) {
			int i = dao.updatePassword(phone,newPwd);
			System.out.println(i);
		}
		user = dao.findUserByPhone(phone);
		System.out.println(user);
	}
	
	@Test
	public void test3() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findUserById("483639b594774738b3ac175c1445f975");
		System.out.println(user);
	}
	
	
	@Test
	public void test4() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		int i = dao.modifyStatus("483639b594774738b3ac175c1445f975", 1);
		System.out.println(i);
	}
	
	@Test
	public void test5() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		int i = dao.deleteUser("2");
		System.out.println(i);
		
		
	}
	
	@Test
	public void test6() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		Map<Object,Object> list = dao.userParticulars("483639b594774738b3ac175c1445f975");
		System.out.println(list);
	}
	
	@Test
	public void test7() {
		UserDao dao = ac.getBean("userDao",UserDao.class);
		List<User> list = dao.selectAllUser();
		System.out.println(list.size());
	}
	
}
