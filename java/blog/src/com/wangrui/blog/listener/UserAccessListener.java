package com.wangrui.blog.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserAccessListener implements HttpSessionListener , HttpSessionAttributeListener{

	/**
	 * 在一个会话被创建时调用
	 */
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		Object ac = application.getAttribute("accessCount");

		int accessCount = ((Integer) ac).intValue();
		accessCount++;
		application.setAttribute("accessCount", accessCount);

		// 为当前用户数加1
		int currCount = (Integer) application.getAttribute("currCount");
		currCount++;
		application.setAttribute("currCount", currCount);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// 为当前用户数减1
		ServletContext application = se.getSession().getServletContext();
		int currCount = (Integer) application.getAttribute("currCount");
		currCount--;
		application.setAttribute("currCount", currCount);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String keyName = se.getName();
		if("userInfo".equals(keyName)) {
			ServletContext application = se.getSession().getServletContext();
			int count = (Integer)application.getAttribute("vipCount");
			count++;
			application.setAttribute("vipCount", count);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		String keyName = se.getName();
		if("userInfo".equals(keyName)) {
			ServletContext application = se.getSession().getServletContext();
			int count = (Integer)application.getAttribute("vipCount");
			count--;
			application.setAttribute("vipCount", count);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		HttpSessionAttributeListener.super.attributeReplaced(se);
	}

	
	
}
