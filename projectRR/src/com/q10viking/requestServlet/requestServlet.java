package com.q10viking.requestServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class requestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取URI
		String uri = request.getRequestURI();
		System.out.println("URI: "+ uri);
		
		//获取URL
		String url = request.getRequestURL().toString();
		System.out.println("URL: "+url);
		
		//获取参数信息
		String msg=request.getQueryString();
		System.out.println("msg: "+msg);
		
		//获取协议  
		String protocol = request.getProtocol();
		System.out.println("protocol: "+protocol);
		
		System.out.println("==========================");
		
		//获取请求方法
		String method = request.getMethod();
		System.out.println("method: "+method);
		
		//获取IP
		String ip=request.getRemoteAddr();
		System.out.println("IP: "+ip);
		
		//获取项目路径
		String path = request.getContextPath();
		System.out.println("path: "+path);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
