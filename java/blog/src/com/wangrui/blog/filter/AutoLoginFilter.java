package com.wangrui.blog.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wangrui.blog.bean.Blog;
import com.wangrui.blog.bean.User;
import com.wangrui.blog.service.BlogService;
import com.wangrui.blog.service.UserService;

@WebFilter("*")
public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		Object o = session.getAttribute("userInfo");
		// 没登录
		if(null == o) {
			// 查看Cookie中是否有可以登录的用户信息
			Cookie[] cks = req.getCookies();
			String regName = null;
			String pwd = null;
			
			if(null != cks)
			for(Cookie c : cks) {
				if("regName".equals(c.getName())){
					regName = c.getValue();
				}
				else if("pwd".equals(c.getName())){
					pwd = c.getValue();
				}
			}
			
			if(null != regName && null != pwd) {
				User u = UserService.login(regName, pwd);
				if(null != u) { // 登录成功
					session.setAttribute("userInfo", u);
					
					try {
						Blog b = BlogService.findBlog(u.getUserID());
						session.setAttribute("blogInfo", b);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
			}
			
		} 
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
