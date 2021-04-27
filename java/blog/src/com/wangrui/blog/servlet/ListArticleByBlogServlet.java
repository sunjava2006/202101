package com.wangrui.blog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.blog.bean.Article;
import com.wangrui.blog.service.ArticleService;


@WebServlet("/ListArticleByBlog")
public class ListArticleByBlogServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogID = request.getParameter("blogID");
		int blogid = Integer.parseInt(blogID);
		String pagestr = request.getParameter("page");
		String sizestr = request.getParameter("size");
		int page = 1;
		int size = 8;
		if(null!=pagestr && !"".equals(pagestr)) {
			page = Integer.parseInt(pagestr);
		}
		if(null != sizestr && !"".equals(sizestr)) {
			size = Integer.parseInt(sizestr);
		}
	
		try {
			List<Article> list = ArticleService.listByPage(page, size, blogid);
			int totalcount = ArticleService.totalCount(blogid);
			int totalPage = ArticleService.howManyPage(totalcount, size);
			
			request.setAttribute("list", list);
			request.setAttribute("totalCount", totalcount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currPage", page);
			request.setAttribute("blogID", blogID);
			
			request.getRequestDispatcher("/ArticleList.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		response.getWriter().write("发表成功，下面要查询出文件列表......");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
