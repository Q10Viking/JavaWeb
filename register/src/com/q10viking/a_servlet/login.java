package com.q10viking.a_servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		String name="count";
		Integer object=0;
		context.setAttribute(name, object);
		System.out.println("Init successed");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//设置编码问题
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		//获取信息
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		User user=null;
		try {
			user = new UserService().login(username, password); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new  RuntimeException("网络异常");
		}
		
		if(user != null) {
			System.out.println("Hello "+user.getUsername()+" login successful");
			resp.getWriter().print("Hello "+user.getUsername()+" login successful");
			
			//获取全局管理者
			ServletContext context = this.getServletContext();
			//获取之前的计数值
			Integer num = (Integer) context.getAttribute("count");
			//更新计数值
			context.setAttribute("count", num+1);
			//准备跳转
			//resp.setHeader("refresh", "3;url=http://localhost:80/LoginWeb/show");
		}else {
			
			System.out.println("Sorry,no "+username+".Please try again");
			resp.getWriter().print("Sorry,no "+username+".Please try again");
			//处理响应头
			String name="refresh";
			boolean re=false;
			re=resp.containsHeader(name);
			//检测是否设置成功
			if(re)
				System.out.println("The "+name+"has been setted");
			else
				System.out.println("The "+name+"hasn't been setted");
			resp.setHeader("refresh", "3;url=http://localhost:80/register/index.html");
			//检测是否设置成功
			re=resp.containsHeader(name);
			if(re)
				System.out.println("The "+name+"has been setted");
			else
				System.out.println("The "+name+"hasn't been setted");
		}
		
	}

}
