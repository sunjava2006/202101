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
		req.setAttribute("regInfo", "ע��ɹ�");
		try {
			count = UserService.regist(regName, pwd, email);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("regInfo", "ע��ʧ��");
		} 
		if(1 != count) {
			req.setAttribute("regInfo", "ע��ʧ��");
		}
		// ����ת�������û��Ե�ǰServlet������ת������ҳ�档
		req.getRequestDispatcher("/RegistResult.jsp").forward(req, resp);
		
		// ������������request���󡣰�����������service������
		
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
//        resp.getWriter().write("��ã�"+regName);
	}



	
	
}
