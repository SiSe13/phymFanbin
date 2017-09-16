package com.phym.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phym.util.JsonResult;

/**
 * �������쳣��װ��һ��������
 * @author S_s
 *
 */
public abstract class BaseController {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult<Object> expHandler(Exception e){
		e.printStackTrace();
		return new JsonResult<Object>(e);
	}
}
