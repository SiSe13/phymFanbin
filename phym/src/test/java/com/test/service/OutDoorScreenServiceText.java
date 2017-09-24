package com.test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.phym.entity.OutDoorScreen;
import com.phym.service.OutDoorScreenService;
import com.test.BaseTest;

public class OutDoorScreenServiceText extends BaseTest {
	OutDoorScreenService   us;
	@Before
	public void initService(){
		
		us=ctx.getBean("outDoorScreenService",OutDoorScreenService.class);
	}
	
	@Test
	public void TestRegist(){
		OutDoorScreen outDoorScreen=new OutDoorScreen();
		//outDoorScreen.setoutdoorMediasourceType();
		List<OutDoorScreen> user =us.findOutdoor(outDoorScreen);
		for(OutDoorScreen s:user){
			System.out.println(s);
		}
	}
	
}
