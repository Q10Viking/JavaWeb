package com.q10viking.showServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取全局变量
		ServletContext context = this.getServletContext();
		//获取数值
		Integer num =(Integer)context.getAttribute("count");
		//写到浏览器
		response.getWriter().append("Now there are "+num+" students login successful!");
		//用于在后台显示
		System.out.println("Now there are "+num+" students login successful!");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
