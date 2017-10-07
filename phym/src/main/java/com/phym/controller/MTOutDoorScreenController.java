package com.phym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenException;
import com.phym.service.OutDoorScreenService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("mediaowner/mtout")
public class MTOutDoorScreenController extends BaseController{
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	
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
	
	//媒体资源上传
	@RequestMapping("/outdoor.do")
	public JsonResult<Boolean> uploadResource(OutDoorScreen outDoor) throws OutDoorScreenException{
		//String mediaName,String province,String city,String country,String address,String mediaType,String screenType,String screenSize,String length,String height,String startTime,String endTime,String userName,String photo,String superiority,String aptitude,String remark,String playback
		Boolean bool = outDoorScreenService.uploadResource(outDoor);
		return new JsonResult<Boolean>(bool);
	}
	
	//修改媒体资源
	@RequestMapping("/modifyout.do")
	public JsonResult<Boolean> modifyOutDoor(OutDoorScreen outDoor) throws OutDoorScreenException{
		Boolean bool = outDoorScreenService.modifyOutDoor(outDoor);
		return new JsonResult<Boolean>(bool);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
