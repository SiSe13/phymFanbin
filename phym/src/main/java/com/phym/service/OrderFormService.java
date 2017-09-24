package com.phym.service;

import com.phym.entity.OrderForm;
import com.phym.exception.OrderFormException;

public interface OrderFormService {
	
	//插入订单
	boolean insertOrderForm(OrderForm orderForm,String outdoorId)throws OrderFormException;
}
