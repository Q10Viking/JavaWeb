package com.q10viking.DataSourceUtils;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

public class TestDemo {
	
	@Test
	public void f1() throws SQLException {		
		QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="insert into category values(?,?)";
		
		int i=qu.update(sql, "C008","耳机");
		
		if(i==1) {
			System.out.println("SUCCESSED");
		}
	}
	
	
	//测试ArrayHandler
	@Test
	public void TestArrayHandler() throws SQLException {
		QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		Object[] obj=qu.query(sql, new ArrayHandler());
		System.out.println(Arrays.toString(obj));
	}
	
	//测试ArrayListHandler
	@Test
	public void TestArrayListHandler() throws SQLException{
		QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		List<Object[]>  list = qu.query(sql, new ArrayListHandler());
		
		for(Object[] obj:list) {
			System.out.println(Arrays.toString(obj));
		}
	}
	
	
	//测试BeanHandler
		@Test
		public void TestBeanHandler() throws SQLException {
			QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from category";
			User user=qu.query(sql, new BeanHandler<>(User.class));
			
			System.out.println(user);
		}
	
		
		//测试BeanListHandler
				@Test
		public void TestBeanListHandler() throws SQLException {
				QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
				String sql="select * from category";
				List<User> list = qu.query(sql, new BeanListHandler<>(User.class));
				for(User user:list) {
					System.out.println(user);
				}
			}
				
				

//测试MapHandler
@Test
public void TestMapHandler() throws SQLException{
	QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
	String sql="select * from category";
	Map<String, Object> map = qu.query(sql, new MapHandler());
	System.out.println("test MapHandler");
	System.out.println(map);
}

//测试MapListHandler
@Test
public void TestMapListHandler() throws SQLException {
	QueryRunner qu=new QueryRunner(DataSourceUtils.getDataSource());
	String sql="select * from category";
	List<Map<String, Object>>  mapList = qu.query(sql, new MapListHandler());
	System.out.println("test MapListHandler");
	for(Map<String,Object> map:mapList) {
		System.out.println(map);
	}
}
				
			
		
		
}
