package com.wangrui.blog.service;

import java.sql.SQLException;

import com.wangrui.blog.bean.User;
import com.wangrui.blog.dao.UserDao;

public class UserService {

	public static int regist(String regName, String pwd, String email) throws SQLException {
		return UserDao.save(regName, pwd, email);
	}

	public static User login(String regName, String pwd) {
		User u = null;
		try {
			u = UserDao.findByRegNameAndPwd(regName, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}
}
