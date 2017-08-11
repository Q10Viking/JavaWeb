package com.q10viking.configTest;

import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class configTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//获取日期
		 Calendar rightNow = Calendar.getInstance();
		 Date date = rightNow.getTime();
		 System.out.println(date);
		 
		//获取ServletConfig
		ServletConfig config=this.getServletConfig();
		//获取ServletContext
		ServletContext context = config.getServletContext();
		context.setAttribute("count", 1);
		
		//获取servletName
		String name=config.getServletName();
		System.out.println("servletName: "+name);
		
		//Parameter
		String user = config.getInitParameter("user");
		System.out.println("servletName: "+user);
		
		System.out.println("==========");
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name1=e.nextElement();
			String value=config.getInitParameter(name1);
			System.out.println(name1+" : "+value);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
