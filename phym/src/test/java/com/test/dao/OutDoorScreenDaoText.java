package com.test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.phym.dao.OutDoorScreenDao;
import com.phym.entity.OutDoorScreen;
import com.test.BaseTest;

public class OutDoorScreenDaoText extends BaseTest {
	OutDoorScreenDao dao;
	
	@Before
	public void initDao(){
		dao =ctx.getBean("outDoorScreenDao",OutDoorScreenDao.class);
	}
	
	@Test
	public void testfindOutDoorScreen(){
		OutDoorScreen out=new OutDoorScreen();
		out.setOutdoorCity("110100");
		 List<OutDoorScreen> list = dao.findOutdoor(out);
		 for(OutDoorScreen li :list){
			 System.out.println(li);
		 }
		
	}
}
