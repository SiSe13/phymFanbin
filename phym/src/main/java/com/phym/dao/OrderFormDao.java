package com.phym.dao;

import java.util.List;


import com.phym.entity.OrderForm;

public interface OrderFormDao {
	
	//插入订单
	public int insertOrderForm(OrderForm orderForm);
	//订单详情
	public List<OrderForm> findOrderFormById(String orderFormId);
	//后台订单删除
	public int deleteOrderById(String orderFormId);
	//查询订单编号通过id
	public OrderForm findOrderNumById(String orderFormId);
	//订单的修改
	public int modifyOrder(OrderForm orderForm);
	//查询所有的订单
	public List<OrderForm> findAllOrderForm();
	
	//查询用户所有的订单
	public List<OrderForm> findAllUserOrder(String userId);
	
	
}
