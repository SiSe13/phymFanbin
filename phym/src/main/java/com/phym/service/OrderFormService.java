package com.phym.service;

import java.util.List;
import com.phym.entity.OrderForm;
import com.phym.exception.OrderFormException;

public interface OrderFormService {
	//开始订单
	public Boolean insertOrderForm(String videoName,String startTime,String endTime,String filePath,
            String duration,String remarks,String outDoorId,String cost,String userId)throws OrderFormException;
	//订单详情
	public List<OrderForm> findOrderFormById(String orderFormId) throws OrderFormException;
	//后台订单删除
	public Boolean deleteOrderById(String orderFormId) throws OrderFormException;
	//订单的修改
	public Boolean modifyOrder(OrderForm orderForm)throws OrderFormException;
	
	//查询用户所有订单
	public List<OrderForm> findAllUserOrder(String userId)throws OrderFormException;
	
	//查询所有订单
	public List<OrderForm> findAllOrderForm()throws OrderFormException;
}