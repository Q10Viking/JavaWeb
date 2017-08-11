package com.q10viking.scontext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class scontext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = scontext.class.getClassLoader().getResource("/c3p0-config.xml").getPath();
		System.out.println(path);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//获取ServletContext
		ServletContext context = this.getServletConfig().getServletContext();
		
		//获取初始化参数  
		
		String encoding = context.getInitParameter("encoding");
		                                                
		System.out.println("encoding: "+ encoding);
		
		/*有错误
		System.out.println("===========");
		
		
		Enumeration<String> res = context.getAttributeNames();
		
		while(res.hasMoreElements()) {
			String name=res.nextElement();
			String value=(String) context.getAttribute(name);
			System.out.println(name+" : "+value);
		}
		*/
		//获取真实路径
		
		String url1=context.getRealPath("/");
		System.out.println(url1);
		
		//获取某个文件的路径
		String url2=context.getRealPath("/hello.txt");
		System.out.println(url2);
		
		//以流的形式获取资源  ?路径
	     InputStream Input = context.getResourceAsStream("/1.txt");
	     System.out.println(Input);
	     
	     Input=context.getResourceAsStream("/hello.txt");
	     System.out.println(Input);
		
		//获取文件的MIME类型  
		String mimeType = context.getMimeType("hello.txt");
		System.out.println(mimeType);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
