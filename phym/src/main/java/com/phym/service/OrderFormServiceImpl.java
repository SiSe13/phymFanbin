package com.phym.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.OrderFormDao;
import com.phym.dao.OrderMediaDao;
import com.phym.entity.OrderForm;
import com.phym.entity.OrderMedia;
import com.phym.entity.OutDoorScreen;
import com.phym.entity.User;
import com.phym.exception.OrderFormException;
import com.phym.exception.OrderMediaException;
import com.phym.util.NoteUtil;

@Service("orderFormService")
public class OrderFormServiceImpl implements OrderFormService {
	@Autowired
	private OrderFormDao orderDao;
	@Autowired
	private OrderMediaDao mediaDao;
	@Autowired
	private OutDoorScreenService outService;
	@Autowired
	private UserService userService;
	//订单详情
	public List<OrderForm> findOrderFormById(String orderFormId) throws OrderFormException {
		if(orderFormId ==null) {
			throw new OrderFormException("无效的ID");
		}
		List<OrderForm> list = orderDao.findOrderFormById(orderFormId);
		if(list.isEmpty()) {
			throw new OrderFormException("无效的订单,无内容");
		}
		return list;
	}
	
	////后台订单删除
	public Boolean deleteOrderById(String orderFormId) throws OrderFormException {
		if(orderFormId ==null) {
			throw new OrderFormException("无效的ID");
		}
		OrderForm ord = orderDao.findOrderNumById(orderFormId);
		if(ord ==null) {
			throw new OrderFormException("无效的订单");
		}
		String number = ord.getNumber();
		
		int num = orderDao.deleteOrderById(orderFormId);
		int nun = mediaDao.deleteOrderMedia(number);
		if((num + nun) !=2 ) {
			throw new OrderFormException("删除订单失败");
		}
		
		return true;
	}
	//订单的修改
	public Boolean modifyOrder(OrderForm orderForm) {
		if(orderForm == null) {
			throw new OrderFormException("无效的参数");
		}
		String orderFormId = orderForm.getId();
		OrderForm order = orderDao.findOrderNumById(orderFormId);
		if(order ==null) {
			throw new OrderFormException("无效的ID");
		}
		String number = order.getNumber();
		if(number ==null) {
			throw new OrderFormException("未找到该订单");
		}
		String videoType = orderForm.getVideoType();
		int orderType = orderForm.getOrderType();
		int status = orderForm.getStatus();
		String htRemark = orderForm.getHtRemark();
		String auditName = orderForm.getAuditName();
		if(order.getVideoType().equals(videoType)) {
			videoType = null;
		}
		if(order.getOrderType() == orderType) {
			orderType = -1;
		}
		if(order.getStatus() == status) {
			status = -1;
		}
		if(order.getHtRemark().equals(htRemark)) {
			htRemark = null;
		}
		if(order.getAuditName().equals(auditName)) {
			auditName = null;
		}
		orderForm.setAuditTime(new Timestamp(System.currentTimeMillis()));
		int m = mediaDao.updateMediaStatus(number, orderType);
		int n = orderDao.modifyOrder(orderForm);
		if((m+n) !=2) {
			throw new OrderFormException("订单修改失败");
		}
		return true;
	}
	//查询所有订单
	public List<OrderForm> findAllOrderForm() {
		List<OrderForm> list = orderDao.findAllOrderForm();
		if(list ==null) {
			throw new OrderFormException("暂无订单");
		}

		return list;
	}
	
	//查询用户所有订单
		public List<OrderForm> findAllUserOrder(String userId) throws OrderFormException {
			if(userId == null) {
				throw new OrderFormException("无效的用户ID");
			}
			List<OrderForm> list = orderDao.findAllUserOrder(userId);
			if(list.isEmpty()) {
				throw new OrderFormException("你还没有订单");
			}
			
			return list;
		}
	
	
	
	//广告主上传视频
	public Boolean insertOrderForm(String videoName,String startTime,String endTime,String filePath,
            String duration,String remarks,String outDoorId,String cost,String userId) {
		if(outDoorId ==null) {
			throw new OrderFormException("无效的ID");
		}
		if(videoName ==null ||videoName.trim().isEmpty()) {
			throw new OrderFormException("请输入广告名称");
		}
		if(startTime ==null ||startTime.trim().isEmpty()) {
			throw new OrderFormException("请选择开始播放时间");
		}
		if(endTime ==null ||endTime.trim().isEmpty()) {
			throw new OrderFormException("请选择结束播放时间");
		}
		if(filePath ==null ||filePath.trim().isEmpty()) {
			throw new OrderFormException("请上传视频");
		}
		if(duration ==null ||duration.trim().isEmpty()) {
			throw new OrderFormException("请输入播放时长");
		}
		if(cost ==null ||cost.trim().isEmpty()) {
			throw new OrderFormException("费用错误");
		}
		if(userId ==null ||userId.trim().isEmpty()) {
			throw new OrderFormException("用户ID错误");
		}
		OrderForm orderForm = new OrderForm();
		List<OutDoorScreen> list = outService.findOutDoorContent(outDoorId);
		Map<String,Integer> map = new HashMap<String, Integer>();
		String days = NoteUtil.getTwoDay(startTime, endTime);
		
		int num = 0;
		for(OutDoorScreen out : list) {
			String ID = out.getOutdoorId(); 
			int n = Integer.parseInt(out.getOutdoorUnitPrice())*Integer.parseInt(out.getOutdoorFrequency())*Integer.parseInt(days) * Integer.parseInt(duration);
			num += n;
			map.put(ID, n);
		}
		
		String fCost = num +"";
		if(!fCost.equals(cost)) {
			throw new OrderFormException("费用计算失败");
		}
		orderForm.setId(NoteUtil.createId());
		int rand = (int)(Math.random()*100000+100000);
		String number = "PHYM"+System.currentTimeMillis()+rand;
		orderForm.setNumber(number);
		orderForm.setVideoName(videoName);
		orderForm.setStartTime(startTime);
		orderForm.setEndTime(endTime);
		orderForm.setVideoType(filePath);
		orderForm.setDuration(duration);
		orderForm.setUserId(userId);
		orderForm.setOrderType(0);
		orderForm.setStatus(0);
		orderForm.setCreateTime(new Timestamp(System.currentTimeMillis()));
		orderForm.setQtRemark(remarks);
		orderForm.setCost(fCost);
		int t = orderDao.insertOrderForm(orderForm);
		if(t !=1) {
			throw new OrderFormException("订单生成失败");
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			OrderMedia media = new OrderMedia();
			media.setId(NoteUtil.createId());
			media.setNumber(number);
			media.setStatus(0);
			media.setMediaId(entry.getKey());
			media.setMediaCost(entry.getValue()+"");
			User user = userService.findUserById(userId);
			media.setAdvertName(user.getUser_nickname());
			int ss = mediaDao.insertOrderMedia(media);
			if(ss !=1) {
				throw new OrderMediaException("订单衍生失败");
			}
		}
		return true;
	}

	//通过订单编号查询订单
		public List<Object> findOrderFormByNumber(String number) throws OrderFormException {
			if(number==null) {
				throw new OrderFormException("参数错误");
			}
			OrderForm order = orderDao.findOrderFormByNumber(number);
			if(order ==null) {
				throw new OrderFormException("网络延迟");
			}
			String userId = order.getUserId();
			User user = userService.findUserById(userId);
			if(user ==null) {
				throw new OrderFormException("查询订单失败");
			}
			List<Object> list = new ArrayList<Object>();
			list.add(number);
			list.add(order.getVideoName());
			list.add(order.getStartTime());
			list.add(order.getEndTime());
			list.add(order.getVideoType());
			list.add(order.getDuration());
			list.add(order.getOrderType());
			list.add(order.getStatus());
			list.add(order.getCreateTime());
			list.add(user.getUser_nickname());
			list.add(order.getQtRemark());
			list.add(order.getCost());
			list.add(order.getHtRemark());
			list.add(order.getAuditTime());
			list.add(order.getAuditName());
			if(list.isEmpty()) {
				throw new OrderFormException("详情失败");
			}
			return list;
		}
	
		//通过订单编号查询订单包含大屏的信息
		public List<OutDoorScreen> findOrderMediaByNumber(String number) throws OrderFormException {
			if(number ==null) {
				throw new OrderFormException("无效的参数");
			}
			List<OrderMedia> list1 = mediaDao.findOrderMediaByNumber(number);
			
			List<OutDoorScreen> list2 = new ArrayList<OutDoorScreen>();
			for(OrderMedia order : list1) {
				String ID = order.getMediaId();
				String cost =order.getMediaCost();
				OutDoorScreen out = outService.findOutDoorScreenById(ID);
				out.setDemo2(cost);
				list2.add(out);
			}
			return list2;
		}

}
