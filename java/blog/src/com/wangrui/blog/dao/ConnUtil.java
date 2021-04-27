package com.wangrui.blog.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {

	private static  String url ;
	private static  String user;
	private static  String pwd;
	private static  String driver;
	
	static {
		Properties p = new Properties();
		InputStream in = ConnUtil.class.getResourceAsStream("/db.properties");
		try {
			p.load(in);
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			driver = p.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
}
