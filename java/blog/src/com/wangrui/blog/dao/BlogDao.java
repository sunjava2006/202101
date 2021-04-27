package com.wangrui.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangrui.blog.bean.Blog;

public class BlogDao {

	public static Blog findByUserID(int userid) throws SQLException {
		Blog b = null;
		String sql = "select * from t_blogs where user_id=?";
		
		ResultSetExtractor<Blog> ext = new ResultSetExtractor<Blog>() {
			@Override
			public Blog extract(ResultSet rst) throws SQLException {
				Blog b = null;
				if(rst.next()) {
					int blogID = rst.getInt(1);
					String blogName = rst.getString(2);
					String nickName = rst.getString(3);
					String photo = rst.getString(4);
					int userID = rst.getInt(5);
					b = new Blog(blogID, blogName, nickName, photo, userID);
				}
				return b;
			}
		};
		b = JdbcTemplate.select(sql, ext, userid);
		return b;
	}
	
	public static int add(String blogName, String nickName, String photo, Integer userID) throws SQLException {
		String sql = "insert into t_blogs values(seq_blogs.nextval, ?,?,?,?)";
		return JdbcTemplate.saveOrUpdate(sql, blogName,nickName, photo, userID);
	}
}
