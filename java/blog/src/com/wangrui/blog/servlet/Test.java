package com.wangrui.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Test implements Servlet{

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("------------init-----------");
	}
	

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	String name ;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletContext().getRealPath("/");
		System.out.println(path);
		
		name = request.getParameter("name");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println(name);
	}

	
	@Override
	public void destroy() {
		System.out.println("==========destroy=========");
		
	}
}
