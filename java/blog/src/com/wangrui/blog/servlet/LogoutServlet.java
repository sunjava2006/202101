package com.wangrui.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("userInfo"); // 删除保存在Session中的数据。
		session.removeAttribute("blogInfo");
//		session.invalidate(); // 让Session失效
		
		Cookie c1 = new Cookie("regName", "");
		c1.setMaxAge(0); // 设置cookie生命周期
		Cookie c2 = new Cookie("pwd", "");
		c2.setMaxAge(0);
		response.addCookie(c1);
		response.addCookie(c2);
		
		response.sendRedirect("/");
	}

}
