package com.q10viking.a_servlet;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.q10viking.DataSource.DataSourceUtils;

public class UserDao {
	public  User getUserByUsernameAndPwd(String username,String password) throws SQLException {
		
		System.out.println("Enter getUserByUsernameAndPwd function");
		
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from user where username=? and password=?";
		
		User user = qr.query(sql, new BeanHandler<>(User.class), username,password);
		
		if(user==null)
			System.out.println("The user is null");
		System.out.println("Exit getUserByUsernameAndPwd function");
		return user;
	}

	public int addUser(User user) throws SQLException {
		
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());

		String sql="insert into user(username,password,name,email,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
	
		int i=qr.update(sql,user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getSex(),user.getBirthday(),user.getHobby()
				);
		
		return i;
	}
}
