package com.wangrui.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/publishArticle", "/MyBlog.jsp"})
public class SessionTimeoutFilter implements Filter {


 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		if(null == session.getAttribute("userInfo")) {
			HttpServletResponse res = (HttpServletResponse) response;

			req.setAttribute("msg", "会话超时，请重新登录。");
			req.getRequestDispatcher("/Login.jsp").forward(request, response);
			
//			res.sendRedirect("/Login.jsp");
		}else {
		    chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
