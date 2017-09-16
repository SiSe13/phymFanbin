package com.test;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

	protected ClassPathXmlApplicationContext ctx;
	//³õÊ¼»¯ SpringÈÝÆ÷
	@Before 
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
				"conf/spring-web.xml",
				"conf/spring-mybatis.xml");
	}

}
