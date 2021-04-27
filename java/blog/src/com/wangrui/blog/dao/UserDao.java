package com.wangrui.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangrui.blog.bean.User;

public class UserDao {

	public static User findByRegNameAndPwd(String regName, String pwd) throws SQLException {
		User u = null;
		String sql = "select * from t_users where reg_name=? and pwd=?";
		
		ResultSetExtractor<User> ext = new ResultSetExtractor() {
			@Override
			public User extract(ResultSet rst) throws SQLException {
				User u = null;
				if(rst.next()) {
					Integer userID = rst.getInt("user_id");
					String regname = rst.getString("reg_name");
					String p = rst.getString("pwd");
					String email = rst.getString("email");
					u = new User(userID, regname, p, email);
				}
				return u;
			}
		};
		
		u = JdbcTemplate.select(sql, ext, regName, pwd);
		
		return u;
	}
	
	public static  int save(String regName, String pwd, String email) throws SQLException {
		String sql = "insert into t_users values(seq_users.nextval, ?,?,?)";
		return JdbcTemplate.saveOrUpdate(sql, regName, pwd, email);
	}
}
