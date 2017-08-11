package com.q10viking.registerServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.q10viking.a_servlet.User;
import com.q10viking.a_servlet.UserService;


public class registerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		User user = new User();
		UserService us=new UserService();
		
		
		try {
			//封装数据
			BeanUtils.populate(user, request.getParameterMap());
		
			//调用Userservice.register
			int result=us.register(user);
			
			//判断结果
			if(result==1) {
				request.setAttribute("result", "register successed");
				request.getRequestDispatcher("/msg").forward(request, response);
			}else {
				request.setAttribute("result", "register failed");
				request.getRequestDispatcher("/msg").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
