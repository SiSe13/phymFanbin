package com.phym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.OrderForm;
import com.phym.exception.OrderFormException;
import com.phym.service.OrderFormService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("order")
public class OrderFormController extends BaseController{
	
	@Autowired
	private OrderFormService orderFormService;
	
	@RequestMapping("/insertOrder.do")
	public JsonResult<Boolean> insertOrderForm(OrderForm orderForm,String outdoorId){
		boolean boo=orderFormService.insertOrderForm(orderForm,outdoorId);
		if(!boo){
			throw new OrderFormException("添加失败,请重试");
		}
		return new JsonResult<Boolean>(boo);
	}
	
	
}
