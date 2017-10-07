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
@RequestMapping("advertiser/outdoor")
public class OutDoorScreenController extends BaseController{
	
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	
	//删除媒体资源
	@RequestMapping("/delout.do")
	public JsonResult<Boolean> deleteOutDoor(String outDoorId) throws OutDoorScreenException{
		Boolean bool = outDoorScreenService.deleteMediaResource(outDoorId);
		return new JsonResult<Boolean>(bool);
	}
	
	//搜索大屏
	@RequestMapping("/searchOutDoor.do")
	public JsonResult<List<OutDoorScreen>> findOutdoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorFrequency,String outdoorScreenType,String outdoorMediasourceType,int pager) throws OutDoorScreenException{
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
		List<OutDoorScreen> list=outDoorScreenService.findOutDoor(outdoorProvince, outdoorCity, outdoorCountry, outdoorScreenType, outdoorMediasourceType, pager);
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	//点击户外大屏加载审核通过的所有资源
	@RequestMapping("/findoutScreen.do")
	public JsonResult<List<OutDoorScreen>> findOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,int pager) throws OutDoorScreenException{
		if(outdoorProvince.equals("请选择")) {
			outdoorProvince=null;
		}
		if(outdoorCity.equals("请选择")) {
			outdoorCity=null;
		}
		if(outdoorCountry.equals("请选择")) {
			outdoorCountry=null;
		}
		outdoorScreenType = null;
		outdoorMediasourceType = null;
		List<OutDoorScreen> list=outDoorScreenService.findOutDoor(outdoorProvince,outdoorCity,outdoorCountry,outdoorScreenType,outdoorMediasourceType,pager);
		
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	//订单加载
	@RequestMapping("/findoutScreencontent.do")
	public JsonResult<List<OutDoorScreen>> findOutDoorContent(String outDoorId) throws OutDoorScreenException{
		List<OutDoorScreen> list = outDoorScreenService.findOutDoorContent(outDoorId);
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	//查询记录数
	@RequestMapping("/loadCounts.do")
	public JsonResult<Object> sumOutDoor(OutDoorScreen outDoor)throws OutDoorScreenException{
		if(outDoor.getOutdoorProvince().equals("请选择")) {
			outDoor.setOutdoorProvince(null);
		}
		if(outDoor.getOutdoorCity().equals("请选择")) {
			outDoor.setOutdoorCity(null);
		}
		if(outDoor.getOutdoorCountry().equals("请选择")) {
			outDoor.setOutdoorCountry(null);
		}
		outDoor.setOutdoorScreenType(null);
		outDoor.setOutdoorMediasourceType(null);
		int counts = outDoorScreenService.sumOutDoor(outDoor);
		return new JsonResult<Object>(counts);
	}
	
	//开始订单筛选
		@RequestMapping("/filtrateScreen.do")
		public JsonResult<List<OutDoorScreen>> filtrateScreen(String outdoorProvince, String outdoorCity, String outdoorCountry, String checkshipin,
				String shichang, String outdoorScreenType, String outdoorMediasourceType, int pager){
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
			
			if(outdoorMediasourceType.equals("undefined")) {
				outdoorMediasourceType=null;
			}
			List<OutDoorScreen> list = outDoorScreenService.filtrateScreen(outdoorProvince, outdoorCity, outdoorCountry, checkshipin, shichang, outdoorScreenType, outdoorMediasourceType, pager);
			return new JsonResult<List<OutDoorScreen>>(list);
		}
		//通过id查找媒体资源
		@RequestMapping("/findout.do")
		public JsonResult<OutDoorScreen> findOutDoorScreenById(String outDoorId) throws OutDoorScreenException{
				OutDoorScreen doorScreen = outDoorScreenService.findOutDoorScreenById(outDoorId);
				return new JsonResult<OutDoorScreen>(doorScreen);
		}
		
}
