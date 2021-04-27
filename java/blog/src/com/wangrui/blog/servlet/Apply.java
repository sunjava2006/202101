package com.wangrui.blog.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.wangrui.blog.bean.Blog;
import com.wangrui.blog.bean.User;
import com.wangrui.blog.service.BlogService;


@WebServlet("/applyBlog")
@MultipartConfig
public class Apply extends HttpServlet {

       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===========apply blog============");

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("userInfo");
		if(null != o) { // 用户当前是登录了的。
			User u = (User)o;
			// url为/photos对应的物理目录
			String path = request.getServletContext().getRealPath("/photos");
			System.out.println(path);
			String blogName = request.getParameter("blogName");
			String nickName = request.getParameter("nickName");
			
			Part p = request.getPart("photo");
			String fileName = p.getSubmittedFileName();
			String surfix = fileName.substring(fileName.lastIndexOf("."));
			String newName = System.currentTimeMillis()+surfix;
			InputStream in = p.getInputStream();
			
			FileOutputStream out = null;
			out = new FileOutputStream(path+"/"+newName);
			byte[] buffer = new byte[1024];
			int count = -1;
			while(-1 != (count=in.read(buffer))) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			
			//--------------存储到数据库中-------------
			Blog  b = BlogService.applyBlog(blogName, nickName, newName, u.getUserID());
			session.setAttribute("blogInfo", b);
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/Login.jsp");
		}
		
		
	}

}
