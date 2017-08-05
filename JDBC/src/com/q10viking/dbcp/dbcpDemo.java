package com.q10viking.dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class dbcpDemo {
	//public void main(String[] args) throws Exception {
	
	//硬編碼
	@Test
	public void f1() throws SQLException {

		//建立一个连接池
		BasicDataSource ds=new BasicDataSource();
		//配置信息
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/day07");
		ds.setUsername("root");
		ds.setPassword("root");
		
		//获取一个连接
		Connection conn=ds.getConnection();
		
		String sql="select * from category";
		PreparedStatement st=conn.prepareStatement(sql);
		
		ResultSet re = st.executeQuery();
		
		while(re.next()) {
			System.out.println(re.getString(1)+" : "+re.getString(2));
		}
	}
	
	
	//软编码使用配置文件
	@Test
	public void f2() throws Exception  {
		Properties pro=new Properties();
		pro.load(new FileInputStream("src/dbcp.properties"));
		//获取一个连接池
		DataSource ds=new BasicDataSourceFactory().createDataSource(pro);
		
		Connection conn=ds.getConnection();
		
		String sql="select * from category";
		
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet re = st.executeQuery();
		
		System.out.println("使用配置文件");
		while(re.next()) {
			System.out.println(re.getString(1)+" : "+re.getString(2));
		}
	
	}
	
}


