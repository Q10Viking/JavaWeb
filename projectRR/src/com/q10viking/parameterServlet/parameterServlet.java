package com.q10viking.parameterServlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *由index.html来触发这个页面
 */

public class parameterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取一个值
		String value1=request.getParameter("username");
		System.out.println("username: "+value1);
		
		//获取多个值（数组的形式)
		String[] values = request.getParameterValues("hobby");
		System.out.println("hobby: "+Arrays.toString(values));
		
		
		//map处理全部参数
		Map<String, String[]> map=request.getParameterMap();
		
		//注意for循环的表达方式
		for(String key: map.keySet()) {
			System.out.println(key+"::"+Arrays.toString(map.get(key)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
