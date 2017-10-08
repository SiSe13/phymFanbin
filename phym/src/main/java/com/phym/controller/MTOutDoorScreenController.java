package com.phym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.OrderMedia;
import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenException;
import com.phym.service.OrderFormService;
import com.phym.service.OutDoorScreenService;
import com.phym.service.UserService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("mediaowner/mtout")
public class MTOutDoorScreenController extends BaseController{
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private UserService userService; 
	
	//媒体主点击户外大屏显示媒体资源
	@RequestMapping("/loadout.do")
	public JsonResult<List<OutDoorScreen>> loadOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,String userId) throws OutDoorScreenException{
		if(outdoorProvince.equals("")) {
			outdoorProvince=null;
		}
		if(outdoorCity.equals("")) {
			outdoorCity=null;
		}
		if(outdoorCountry.equals("")) {
			outdoorCountry=null;
		}
		outdoorScreenType = null;
		outdoorMediasourceType = null;
		List<OutDoorScreen> list = outDoorScreenService.loadOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, userId);
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	//媒体主点击搜索筛选媒体资源
	@RequestMapping("/loadouts.do")
	public JsonResult<List<OutDoorScreen>> loadOutDoors(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,String userId) throws OutDoorScreenException{
		if(outdoorProvince.equals("请选择")) {
			outdoorProvince=null;
		}
		if(outdoorCity.equals("请选择")) {
			outdoorCity=null;
		}
		if(outdoorCountry.equals("请选择")) {
			outdoorCountry=null;
		}
		if(outdoorScreenType.equals("屏幕类型")) {
			outdoorScreenType=null;
		}
		if(outdoorMediasourceType.equals("投放类型")) {
			outdoorMediasourceType=null;
		}
		List<OutDoorScreen> list = outDoorScreenService.loadOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, userId);
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	
	//通过媒体主id查询订单
	@RequestMapping("/orderInquiry.do")
	public JsonResult<List<OrderMedia>> findOrderFormByUserId(String userId){
			List<OrderMedia> list = outDoorScreenService.findOrderFormByUserId(userId);
			return new JsonResult<List<OrderMedia>>(list);
	}
		
	//通过id查找媒体资源
	@RequestMapping("/findout.do")
	public JsonResult<OutDoorScreen> findOutDoorScreenById(String outDoorId) throws OutDoorScreenException{
			OutDoorScreen doorScreen = outDoorScreenService.findOutDoorScreenById(outDoorId);
			return new JsonResult<OutDoorScreen>(doorScreen);
	}
	
	
	//通过订单编号查询订单
	@RequestMapping("/rderIndent.do")
	public JsonResult<List<Object>> findOrderFormByNumber(String number){
		List<Object> list = orderFormService.findOrderFormByNumber(number);
		return new JsonResult<List<Object>>(list);
	}
	
	
	//根据用户名修改密码
	@RequestMapping("/checkpassword.do")
	public JsonResult<Boolean> updatePwd(String user_nickname, String user_password, String newpass, String newpassAgain){
			Boolean bool = userService.updatePwd(user_nickname, user_password, newpass, newpassAgain);
			return new JsonResult<Boolean>(bool);
	}
	
	
	
	
	
	
	
	
	
}
