package com.wangrui.blog.service;

import java.sql.SQLException;
import java.util.List;

import com.wangrui.blog.bean.Article;
import com.wangrui.blog.dao.ArticleDao;

public class ArticleService {

	public static void publishArticle(String title, Integer typeID, String content,Integer blogID) {
		try {
			ArticleDao.add(title, typeID, content, blogID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int totalCount(int blogid) throws SQLException {
		return ArticleDao.totalCount(blogid);
	}
	
	public static List<Article> listByPage(int page, int size, int blogid) throws SQLException{
		return ArticleDao.list(page, size, blogid);	
	}
	
	public static int howManyPage(double total, int size) {
		return (int)(Math.ceil(total/size));
	}
}
