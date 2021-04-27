package com.wangrui.blog.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.blog.service.UserService;

@WebServlet(urlPatterns = "/regist")
public class RegistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regName = req.getParameter("regName");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		int count = -1;
		
		req.setAttribute("regName", regName);
		req.setAttribute("regInfo", "注册成功");
		try {
			count = UserService.regist(regName, pwd, email);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("regInfo", "注册失败");
		} 
		if(1 != count) {
			req.setAttribute("regInfo", "注册失败");
		}
		// 请求转发。将用户对当前Servlet的请求，转发给了页面。
		req.getRequestDispatcher("/RegistResult.jsp").forward(req, resp);
		
		// 服务器创建了request对象。把这个对象给了service方法。
		
//		String host = req.getHeader("Host");
//		System.out.println(host);
//        System.out.println(req.getHeader("User-Agent"));	
//        
//        Enumeration<String> heads = req.getHeaderNames();
//        while(heads.hasMoreElements()) {
//        	String h = heads.nextElement();
//        	System.out.println(h +":"+req.getHeader(h));
//        }
//        
//        System.out.println(req.getRemoteAddr());
//        System.out.println(req.getRemotePort());
//        System.out.println(req.getServerName());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getServerPort());
//        
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write("你好："+regName);
	}



	
	
}
