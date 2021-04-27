package com.wangrui.blog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


//@WebFilter(value="*", initParams = {@WebInitParam(name = "charEncode", value = "utf-8")} )
public class CharcodeFilter implements Filter {

	String charset;
	
	public void init(FilterConfig config) throws ServletException {
		this.charset = config.getInitParameter("char");
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("----------------------");
		request.setCharacterEncoding(this.charset);
		chain.doFilter(request, response);
		System.out.println("----------------------");
	}

	public void destroy() {
		
	}
	
	

}
