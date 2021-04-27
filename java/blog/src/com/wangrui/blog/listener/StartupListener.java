package com.wangrui.blog.listener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class StartupListener implements ServletContextListener , ServletContextAttributeListener{
	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext application = sce.getServletContext();
		String path = application.getRealPath("/WEB-INF");
		FileReader reader = null;
		BufferedReader bfreader = null;
		int count = 0;
		try {
			reader = new FileReader(path+"/accessCount.txt");
			bfreader = new BufferedReader(reader);
			String countstr = bfreader.readLine();
			count = Integer.parseInt(countstr);
			bfreader.close();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			application.setAttribute("accessCount", count);
			application.setAttribute("currCount", 0);
			application.setAttribute("vipCount", 0);
		}
   }
   
    public void contextDestroyed(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         int count = (Integer)application.getAttribute("accessCount");
         FileWriter writer = null;
         String path = application.getRealPath("/WEB-INF");
         try {
			writer = new FileWriter(path+"/accessCount.txt");
			writer.write(String.valueOf(count));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
         
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		if("accessCount".equals(attributeName)) {
			int count = (Integer)event.getValue();
			if(0 == count%10) {
				ServletContext application = event.getServletContext();
		         
		         FileWriter writer = null;
		         String path = application.getRealPath("/WEB-INF");
		         try {
					writer = new FileWriter(path+"/accessCount.txt");
					writer.write(String.valueOf(count));
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
    
	
}
