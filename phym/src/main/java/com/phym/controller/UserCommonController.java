package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.service.UserService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("advertiser/userCommon")
public class UserCommonController extends BaseController{
	@Autowired
	private UserService userService; 
	
	//根据用户名修改密码(广告主)
	@RequestMapping("/checkpassword.do")
	public JsonResult<Boolean> updatePwd(String user_nickname, String user_password, String newpass, String newpassAgain){
			Boolean bool = userService.updatePwd(user_nickname, user_password, newpass, newpassAgain);
			return new JsonResult<Boolean>(bool);
	}
	
	
	

}
