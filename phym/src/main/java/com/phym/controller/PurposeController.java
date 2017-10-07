package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenException;
import com.phym.service.OutDoorScreenService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("purpose")
public class PurposeController {
	
	@Autowired
	private OutDoorScreenService outDoorScreenService;
	
	//通过id查找媒体资源
	@RequestMapping("/findout.do")
	public JsonResult<OutDoorScreen> findOutDoorScreenById(String outDoorId) throws OutDoorScreenException{
			OutDoorScreen doorScreen = outDoorScreenService.findOutDoorScreenById(outDoorId);
			return new JsonResult<OutDoorScreen>(doorScreen);
	}
	
}
