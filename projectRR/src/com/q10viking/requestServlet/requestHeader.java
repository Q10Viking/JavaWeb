package com.q10viking.requestServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class requestHeader extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取浏览器内核
		String browser = request.getHeader("user-agent");
		System.out.println("browser kernel: "+browser);
		
		//防盗链
		String refer=request.getHeader("referer");
		System.out.println("refer: "+refer);
		if(refer==null) {
			System.out.println("用户手动输入的网址");
		}else {
			System.out.println("来自其它页面的跳转");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
