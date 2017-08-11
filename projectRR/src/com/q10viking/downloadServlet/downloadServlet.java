package com.q10viking.downloadServlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


public class downloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Server","Q10Viking-server");
		//获取要下载文件的名车
		String fileName = request.getParameter("name");
		System.out.println(fileName);
		//===============修改======================
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		//=======================================
		
		System.out.println(fileName);
		//获取SerlvetContext
		ServletContext context = this.getServletConfig().getServletContext();
		
		//获取文件的MIME类型
		String mimeType=context.getMimeType(fileName);
		System.out.println(mimeType);
		//设置响应头content-type类型
		response.setContentType(mimeType);
		
		//设置响应头content-disposition
		//response.setHeader("content-disposition", "attachment;filename="+fileName);
		
		//======修改==========
		//适用chrome，不适用IE,fireFox
		//response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
		
		//优化对应不同浏览器的形式,但是IE下载中文还是不能下载，因为解析内容都错误了
		String file = DownLoadUtils.getName(request.getHeader("user-agent"), fileName);
		response.setHeader("content-disposition", "attachment;filename="+file);
		
		//================
		
		
		
		//设置流  
		InputStream in = context.getResourceAsStream("/download/"+fileName);
		
		ServletOutputStream os = response.getOutputStream();
		
		/*
		int len=-1;
		byte[] b=new byte[1024];
		
		while((len=in.read(b))!=-1) {
			os.write(b, 0, len);
		}
		*/
		IOUtils.copy(in, os);
		os.close();
		in.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
