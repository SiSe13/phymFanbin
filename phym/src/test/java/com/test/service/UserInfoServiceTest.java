package com.test.service;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.phym.entity.UserInfo;
import com.phym.service.UserInfoService;
import com.test.BaseTest;

public class UserInfoServiceTest extends BaseTest {
	UserInfoService info;
	@Before
	public void initService(){
		info=ctx.getBean("userInfoService",UserInfoService.class);
	}
	
	@Test
	public void updataUserInfo(){
		UserInfo userInfo=new UserInfo();
		userInfo.setUserId("4d440d94c7814837b424b16053ad3152");
		userInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userInfo.setAddr("河北省保定市");
		boolean n=  info.updateUserInfo(userInfo);
		System.out.println(n);
	}
}
