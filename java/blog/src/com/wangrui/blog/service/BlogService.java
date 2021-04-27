package com.wangrui.blog.service;

import java.sql.Blob;
import java.sql.SQLException;

import com.wangrui.blog.bean.Blog;
import com.wangrui.blog.dao.BlogDao;

public class BlogService {

	public static Blog findBlog(int userid) throws SQLException {
		return BlogDao.findByUserID(userid);
	}
	
	public static Blog applyBlog(String blogName, String nickName, String photo, Integer userID) {
		Blog b = null;
		try {
			int count = BlogDao.add(blogName, nickName, photo, userID);
			if(1 == count) {
				b = findBlog(userID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
