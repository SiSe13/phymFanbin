package com.test.service;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.phym.entity.OrderForm;
import com.phym.service.OrderFormService;
import com.phym.util.Md5Util;
import com.test.BaseTest;

public class OrderFormServiceTest extends BaseTest {
	OrderFormService	 info;
	@Before
	public void initService(){
		info=ctx.getBean("orderFormService",OrderFormService.class);
	}
	
	@Test
	public	void test1(){
		OrderForm our = new OrderForm();
		our.setId(Md5Util.createId());
		our.setNumber("PHYM"+System.currentTimeMillis()+(int)((Math.random()*9+1)*100000));
		our.setVideoName("我是中国人");
		our.setStartTime("2017-09-23");
		our.setEndTime("2017-09-26");
		our.setVideoType("djakhd5656ajfakjfh.mp4");
		our.setUserId("36345b104647424baeaffdf2c5314775");
		our.setDuration("15");
		our.setOrderType(0);
		our.setStatus(0);
		our.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		our.setCost("500");
		String outdoorId="7228384079a24ad6a05af6f501a1c164,abdb81095eef46efb4792ecb363b4517,";
		boolean boo=info.insertOrderForm(our, outdoorId);
		System.out.println(boo);
	}
}
