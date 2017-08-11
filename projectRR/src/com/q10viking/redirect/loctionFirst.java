package com.q10viking.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class loctionFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append("location First");
		//设置状态码
		//response.setStatus(302);
		
		//设置响应的响应头
		//response.setHeader("location","/projectRR/ls");
		
		response.sendRedirect("/projectRR/ls");
		System.out.println("Hello this is location First");
		System.out.println("Then go to  location Second immediately");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
