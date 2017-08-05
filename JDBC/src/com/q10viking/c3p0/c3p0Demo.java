package com.q10viking.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Demo {
	
	//硬编码
	@Test
	public void f1() throws Exception {
		//创建一个连接池对象
		ComboPooledDataSource ds=new ComboPooledDataSource();
		
		//配置信息
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://127.0.0.1/day07");
		ds.setUser("root");
		ds.setPassword("root");
		
		//获取连接
		Connection conn=ds.getConnection();
		
		String sql="select * from category";
		
		PreparedStatement st=conn.prepareStatement(sql);
		
		ResultSet re=st.executeQuery();
		
		while(re.next()) {
			System.out.println(re.getString(1)+" : "+re.getString(2));
		}
	}
	
	//软编码
	@Test
	public void f2() throws SQLException {
		
		//使用默认配置
		//ComboPooledDataSource ds=new ComboPooledDataSource();
		//使用命名配置
		ComboPooledDataSource ds=new ComboPooledDataSource("Q10Viking");
		//获取连接
				Connection conn=ds.getConnection();
				
				String sql="select * from category";
				
				PreparedStatement st=conn.prepareStatement(sql);
				
				ResultSet re=st.executeQuery();
		
				System.out.println("软编码");
				while(re.next()) {
					
					System.out.println(re.getString(1)+" : "+re.getString(2));
				}
	}
	
}
