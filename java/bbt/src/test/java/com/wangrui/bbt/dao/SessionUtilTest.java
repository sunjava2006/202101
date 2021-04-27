package com.wangrui.bbt.dao;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import junit.framework.TestCase;

public class SessionUtilTest extends TestCase {

	public void testGetSession() {
		SqlSession s = SessionUtil.getSession();
		Connection c = s.getConnection();
		System.out.println(c.getClass().getName());
		
		s.close();
		assertNotNull(s);
		
	}

}
