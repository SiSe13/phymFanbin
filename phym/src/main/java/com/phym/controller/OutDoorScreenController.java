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
	
	@RequestMapping("/findoutScreen.do")
	public JsonResult<List<OutDoorScreen>> findOutdoor(OutDoorScreen outDoorScreen){
		List<OutDoorScreen> list=outDoorScreenService.findOutdoor(outDoorScreen);
		
		return new JsonResult<List<OutDoorScreen>>(list);
		
	}
}
