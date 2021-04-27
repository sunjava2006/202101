package com.wangrui.blog.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.blog.bean.Blog;
import com.wangrui.blog.bean.User;
import com.wangrui.blog.service.BlogService;
import com.wangrui.blog.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("code");
		if(null != o) {
			String scode = (String) o;
			String code = request.getParameter("code");
			if(scode.equals(code)) {
				String regName = request.getParameter("regName");
				String pwd = request.getParameter("pwd");
				
				// 调用Model 
				User u = UserService.login(regName, pwd);
				if(null != u) { // 登录成功
					session.setAttribute("userInfo", u);
					
					try {
						Blog b = BlogService.findBlog(u.getUserID());
						session.setAttribute("blogInfo", b);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					// 判断是否选择了自动登录
					String auto = request.getParameter("autoLogin");
					if("on".equals(auto)) {
						// 创建Cookie，将放入respons响应对象中。
						Cookie c1 = new Cookie("regName", regName);
						c1.setMaxAge(3600*24*10); // 设置cookie生命周期
						Cookie c2 = new Cookie("pwd", pwd);
						c2.setMaxAge(3600*24*10);
						response.addCookie(c1);
						response.addCookie(c2);
					}
					
					
					response.sendRedirect("/");
				}else { // 登录不成功
					request.setAttribute("msg", "用户名或密码不正确。");
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
					return;
				}
				
			}else { // 验证码不等
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
				return;
			}
		}else { // session中没有验证码
			response.sendRedirect("/Login.jsp");
		}
	}

}
