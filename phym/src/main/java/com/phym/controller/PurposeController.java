package com.phym.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phym.entity.OutDoorScreen;
import com.phym.entity.UserInfo;
import com.phym.exception.OutDoorScreenException;
import com.phym.service.OutDoorScreenService;
import com.phym.service.UserInfoService;
import com.phym.service.UserService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping(value={"advertiser/purpose","mediaowner/purpose","purpose"})
public class PurposeController {
	
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	@Autowired
	private UserInfoService infoService;
	@Autowired
	private UserService userService;
	
	
	//通过id查找媒体资源
	@RequestMapping("/findout.do")
	public JsonResult<OutDoorScreen> findOutDoorScreenById(String outDoorId) throws OutDoorScreenException{
			OutDoorScreen doorScreen = outDoorScreenService.findOutDoorScreenById(outDoorId);
			return new JsonResult<OutDoorScreen>(doorScreen);
	}
	
	//通过用户id查询完善资料
	@RequestMapping("/userId.do")
	public JsonResult<UserInfo> findUserInfoByUserId(String userId){
		UserInfo info = infoService.findUserInfoByUserId(userId);
		return new JsonResult<UserInfo>(info);
	}
	
	//退出
	@RequestMapping("/exit.do")
	public void exit(HttpServletRequest request,String userId){
		Boolean boo=userService.dropOut(userId);
		if(boo){
			request.getSession().removeAttribute("user");
		}
		
	}
	
	
	
}
