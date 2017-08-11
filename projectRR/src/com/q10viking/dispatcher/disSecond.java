package com.q10viking.dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class disSecond extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("who resend the request for me?");
		System.out.println(request.getAttribute("name"));
		System.out.println("What do you want to do?");
		System.out.println("Q10Viking want to borrow "+"《"+request.getParameter("book")+"》 from you.");
	}

}
