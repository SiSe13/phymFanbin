package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.UserInfo;
import com.phym.service.UserInfoService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("info")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/updateUserInfo.do")
	public JsonResult<Boolean> updateUserInfo(UserInfo userInfo){
		boolean boo=userInfoService.updateUserInfo(userInfo);
		return new JsonResult<Boolean>(boo);
	}
}
