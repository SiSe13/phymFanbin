package com.test.dao;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import com.phym.dao.OrderFormDao;
import com.phym.entity.OrderForm;
import com.phym.util.Md5Util;
import com.test.BaseTest;

public class OuderFormDaoTest extends BaseTest {
	OrderFormDao dao;
	
	@Before
	public void initDao(){
		dao =ctx.getBean("orderFormDao",OrderFormDao.class);
	}
	
	
	@Test
	public void test1(){
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
		
		int i=dao.insertOrderForm(our);
		System.out.println(i);
	}

}
