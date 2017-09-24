package com.phym.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phym.entity.OutDoorScreen;
import com.phym.service.OutDoorScreenService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("outdoor")
public class OutDoorScreenController extends BaseController{
	
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	
	/**
	 * 页面加载所有的大屏信息
	 * @param outDoorScreen
	 * @return
	 */
	@RequestMapping("/findoutScreen.do")
	public JsonResult<List<OutDoorScreen>> findOutdoor(OutDoorScreen outDoorScreen){
		
		List<OutDoorScreen> list=outDoorScreenService.findOutdoor(outDoorScreen);
		
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	/**
	 * 检索大屏信息
	 * @param outDoorScreen
	 * @return
	 */
	@RequestMapping("/searchOutDoor.do")
	public JsonResult<List<OutDoorScreen>> findOutdoorScees(OutDoorScreen outDoorScreen){
		if(outDoorScreen.getOutdoorProvince().equals("-1")) {
			outDoorScreen.setOutdoorProvince(null);
		}
		if(outDoorScreen.getOutdoorCity().equals("-1")) {
			outDoorScreen.setOutdoorCity(null);
		}
		if(outDoorScreen.getOutdoorCountry().equals("-1")) {
			outDoorScreen.setOutdoorCountry(null);
		}
		if(outDoorScreen.getOutdoorFrequency().equals("播放频次")) {
			outDoorScreen.setOutdoorFrequency(null);
		}
		if(outDoorScreen.getOutdoorMediasourceType().equals("投放类型")) {
			outDoorScreen.setOutdoorMediasourceType(null);
		}
		if(outDoorScreen.getOutdoorScreenType().equals("屏幕类型")){
			outDoorScreen.setOutdoorMediasourceType(null);
		}
		
		List<OutDoorScreen> list=outDoorScreenService.findOutdoor(outDoorScreen);
		
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
	/**
	 * 查询订单
	 * @param outdoorId
	 * @return
	 */
	@RequestMapping("/findoutScreencontent.do")
	public JsonResult<List<OutDoorScreen>> content(String outdoorId){
		List<OutDoorScreen> list=
				outDoorScreenService.listcontent(outdoorId);
		
		return new JsonResult<List<OutDoorScreen>>(list);
	}
	
}
