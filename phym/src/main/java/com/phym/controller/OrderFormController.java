package com.phym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phym.entity.OrderForm;
import com.phym.service.OrderFormService;
import com.phym.util.JsonResult;

@RestController
@RequestMapping("advertiser/order")
public class OrderFormController extends BaseController{
	@Autowired
	private OrderFormService orderService;
	
	//广告主上传广告
	@RequestMapping("/uploads.do")
	public JsonResult<Boolean> insertOrderForm(String videoName,String startTime,String endTime,String filePath,
            String duration,String remarks,String outDoorId,String cost,String userId){
		Boolean bool = orderService.insertOrderForm(videoName, startTime, endTime, filePath, duration, remarks, outDoorId, cost, userId);
		return new JsonResult<Boolean>(bool);
	}
	
	//查询所有订单
	@RequestMapping("/orderForm.do")
	public JsonResult<List<OrderForm>> findAllUserOrder(String userId){
		List<OrderForm> list = orderService.findAllUserOrder(userId);
		return new JsonResult<List<OrderForm>>(list);
	}
	
	
}
