package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.Message;
import com.phym.service.MessageService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("message")
public class MessageController extends BaseController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/findMessage.do")
	public JsonResult<Message> findMessage(String userId){
		Message message=messageService.findMessage(userId);
		
		return new JsonResult<Message>(message);
	}
	
}
