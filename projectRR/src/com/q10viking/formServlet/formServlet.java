package com.q10viking.formServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class formServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//只对post请求方式有效，对get方式无效
		//将请求流的方法设置成utf-8
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		//通用方法
		//username=new String(username.getBytes("iso-8859-1"),"utf-8");
		//password=new String(password.getBytes("iso-8859-1"),"utf-8");
		System.out.println(username+"::"+password);
	}

}
