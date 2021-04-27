package com.wangrui.blog.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.blog.bean.Article;

public class ArticleDao {

	public static void add(String title, Integer typeID, String content, Integer blogID) throws SQLException {
		String sql = "insert into t_articles(article_id, title,type_id, content,blog_id) values(seq_articles.nextval, ?,?,?,?)";
		
		JdbcTemplate.saveOrUpdate(sql, title, typeID, content, blogID);
	}
	
	public static List<Article> list(int page, int size, int blogid) throws SQLException{
		String sql = "select * from(" + 
				" select a.* , rownum ro from(" + 
				" select * from t_articles where blog_id=? order by article_id desc)a"+
				" where rownum <=?) where ro>?";
		List<Article> list = null;
		
		ResultSetExtractor<List<Article>> ext = (rst)->{
			List<Article> li = new ArrayList<>();
			while(rst.next()) {
				Integer articleID = rst.getInt(1);
				String title = rst.getString(2);
				Integer typeID = rst.getInt(3);
				String content = rst.getString(4);
				Integer blogID = rst.getInt(5);
				Date publishDate = rst.getDate(6);
				
				Article a = new Article(articleID, title, typeID, content, blogID, publishDate);
				li.add(a);
			}
			return li;
		};
		
		list = JdbcTemplate.select(sql, ext, blogid, page*size, (page-1)*size);
		
		return list;
	}
	
	public static int totalCount(int blogid) throws SQLException {
		
		String sql = "select count(*) from t_articles where blog_id=?";
		ResultSetExtractor<Integer> ext = (rst)->{
			Integer count = 0;
			rst.next();
			count = rst.getInt(1);
			return count;
		};
		
		return JdbcTemplate.select(sql, ext, blogid);
		
	}
}
