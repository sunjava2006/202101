package com.wangrui.blog.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(loadOnStartup = 1, urlPatterns = "/fgfgfgfg")
public class StartupServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		System.out.println("===============StartupServlet============");
		application.setAttribute("accessCount", 0);
	}

}
