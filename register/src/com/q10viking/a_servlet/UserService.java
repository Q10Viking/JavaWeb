package com.q10viking.a_servlet;

import java.sql.SQLException;

public class UserService {
	public  User login(String username,String password) throws SQLException {
		System.out.println("Enter login function");
		
		UserDao dao=new UserDao();
		
		User user = dao.getUserByUsernameAndPwd(username, password);
		System.out.println("exit login function");
		return user;
	}

	public int register(User user) throws SQLException {
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}
 
}
