package com.wangrui.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.blog.bean.Blog;
import com.wangrui.blog.service.ArticleService;


@WebServlet("/publishArticle")
public class PublishArticle extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String typeID = request.getParameter("type");
		String content = request.getParameter("content");
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("blogInfo");
		if(null != o) {
			Blog b = (Blog) o;
			
			ArticleService.publishArticle(title, Integer.getInteger(typeID), content, b.getBlogID());
		
		
		    response.sendRedirect("/ListArticleByBlog?blogID="+b.getBlogID());
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
