package com.wangrui.bbt.dao;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private static SqlSessionFactory factory = null;
	
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		java.io.Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static SqlSession getSession() {
		SqlSession session = null;
		session = factory.openSession();
		return session;
	}
	
	
}
