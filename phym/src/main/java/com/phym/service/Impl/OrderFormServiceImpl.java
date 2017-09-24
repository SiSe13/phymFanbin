package com.phym.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.OrderFormDao;
import com.phym.dao.OrderMediaDao;
import com.phym.entity.OrderForm;
import com.phym.entity.OrderMedia;
import com.phym.entity.OutDoorScreen;
import com.phym.exception.OrderFormException;
import com.phym.exception.OrderMediaException;
import com.phym.service.OrderFormService;
import com.phym.service.OutDoorScreenService;
import com.phym.util.Md5Util;
/**
 * 加入订单
 * @author S_s
 *
 */
@Service("orderFormService")
public class OrderFormServiceImpl implements OrderFormService {

	@Autowired
	private OrderFormDao orderFormdao;
	
	@Autowired
	private OrderMediaDao orderMediaDao;
	
	@Autowired
	private OutDoorScreenService   outDoorScreenService;
	
	public boolean insertOrderForm(OrderForm orderForm,String outdoorId)throws OrderFormException,OrderMediaException{
		if(orderForm.getVideoName()==null){
			throw new OrderFormException("广告名称不能为空");
		}
		if(orderForm.getStartTime()==null){
			throw new OrderFormException("请选择开始时间");
		}
		if(orderForm.getEndTime()==null){
			throw new OrderFormException("请选择结束时间");
		}
		if(orderForm.getUserId()==null){
			throw new OrderFormException("请重新登录");
		}
		if(orderForm.getDuration()==null){
			throw new OrderFormException("请输入视频秒数");
		}
		int n=orderFormdao.insertOrderForm(orderForm);
		
		if(n!=1){
			throw new OrderFormException("提交失败");
		}
		
		List<OutDoorScreen> list=outDoorScreenService.listcontent(outdoorId);
		int si=list.size();
		int lean = 0;
		for(OutDoorScreen li:list){
			System.out.println(li.getOutdoorId());
			OrderMedia orderMedia = new OrderMedia();
			orderMedia.setId(Md5Util.createId());
			orderMedia.setNumber(orderForm.getNumber());
			orderMedia.setMediaId(li.getOutdoorId());
			orderMedia.setStatus(0);
			System.out.println(orderMedia);
			lean= orderMediaDao.insertOrderMedia(orderMedia);
			lean += lean;
		}
		
		if(lean!=si){
			throw new OrderMediaException("网络较差,订单创建失败");
		}
		
		return true;
	}

	

}
