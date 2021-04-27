package com.wangrui.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

	public static <T> T select(String sql, ResultSetExtractor<T> ext, Object...args) throws SQLException {
		T t = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;

		try {
			conn = ConnUtil.getConnection();
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			rst = stm.executeQuery();
			t = ext.extract(rst);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
				
		return t;
	}
	
	public static int saveOrUpdate(String sql, Object...args) throws SQLException {
		int count = -1;
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
			conn = ConnUtil.getConnection();
			stm = conn.prepareStatement(sql);
			if(null != args) {
				for(int i=0;i<args.length;i++) {
					stm.setObject(i+1, args[i]);
				}
			}
			count = stm.executeUpdate();
			
			
		} catch (SQLException e) {
			throw e;
		} finally {
			
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
				
		return count;
	}
}
