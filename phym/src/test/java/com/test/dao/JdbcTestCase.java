package com.test.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;
import org.junit.Test;
import com.test.BaseTest;

/**
 * �������ݿ����� 
 */
public class JdbcTestCase 
	extends BaseTest{

	@Test
	public void testDataSource() 
			throws Exception {
		DataSource ds = ctx.getBean(
			"dataSource", DataSource.class);
		Connection conn = ds.getConnection();
		DatabaseMetaData md=conn.getMetaData();
		System.out.println(md);
		//��ѯ���ݿ�汾
		String n = md.getDatabaseProductName();
		String v = md.getDatabaseProductVersion();
		System.out.println(n+v); 
		conn.close();
	}
}
