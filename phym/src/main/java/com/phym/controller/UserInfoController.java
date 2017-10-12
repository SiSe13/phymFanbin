package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phym.entity.UserInfo;
import com.phym.service.UserInfoService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping(value={"advertiser/userInfo","mediaowner/userInfo"})
public class UserInfoController extends BaseController{
	
	@Autowired
	private UserInfoService infoService;
	
	//通过用户id查询完善资料(广告主)
	@RequestMapping("userId.do")
	public JsonResult<UserInfo> findUserInfoByUserId(String userId){
		UserInfo info = infoService.findUserInfoByUserId(userId);
		return new JsonResult<UserInfo>(info);
	}
	
				
	//完善用户资料(广告主)
	@RequestMapping("updateUserInfo.do")
	public JsonResult<Boolean> updateUserInfo(UserInfo userInfo){
		
		Boolean bool = infoService.updateUserInfo(userInfo);
		return new JsonResult<Boolean>(bool);
	}
	
	
	
}
