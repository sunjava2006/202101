package com.wangrui.bbt.dao;

import java.util.List;

import com.wangrui.bbt.beans.User;

import junit.framework.TestCase;

public class UserDaoTest extends TestCase {

//	public void testAddUser() {
//		User u = new User(null,"wang", "123456", null, null);
//		int c = UserDao.addUser(u);
//		System.out.println(c);
//		assertEquals(c, 1);
//	}
	
//	public void testLogin() {
//		User u = UserDao.login("wang", "123456");
//		System.out.println(u);
//		assertNotNull(u);
//	}
	
	/*
	 * public void testList() { List<User> list = UserDao.list(1, 10);
	 * System.out.println(list); assertEquals(list.size(), 10); }
	 */

	 
//	public void testDelete() {
//		int c = UserDao.delete(2);
//		assertEquals(c, 1);
//	}
	
//	public void testGroupByGender() {
//		List list = UserDao.groupByGender();
//		System.out.println(list);
//		assertNotNull(list);
//	}
	
//	public void testSelectByRegName() {
//		List<Map> m = UserDao.SelectByRegName("user_2");
//		System.out.println(m);
//		assertNotNull(m);
//	}
	
//	public void testTotalCount() {
//		int c = UserDao.totalCount();
//		assertEquals(c, 100);
//				
//	}
	
//	public void testUpdatPwd() {
//		User u = new User();
//		u.setUserID(3);
//		u.setPwd("abcdef");
//		int c = UserDao.updatePWd(u);
//		assertEquals(c, 1);
//	}
	
//	public void testselectByUserIdWithOrders() {
//		User u = UserDao.selectByUserIdWithOrders(1);
//		u = UserDao.selectByUserIdWithOrders(1);
//		System.out.println(u);
//		System.out.println(u.getOrders());
//		assertNotNull(u);
//	}
	
//	public void testCatch() {
//		User u = UserDao.login("wang", "aaabbb");
//		System.out.println(u);
//		u.setPwd("aaabbb");
//		UserDao.updatePWd(u);
//		u = UserDao.login("wang", "aaabbb");
//		u = UserDao.login("wang", "aaabbb");
//		assertNotNull(u);
//		
//	}
	
//	public void testSelectByExample() {
//		User u = new User();
////		u.setRegName("wang");
//		u.setName("wang");
////		u.setBankAccount("123456778899");
//		List<User> list = UserDao.selectByExample(u);
//		System.out.println(list);
//		
//	}
	
//	public void testUpdateByExample() {
//		User u = UserDao.login("wang", "aaabbb");
//		System.out.println(u);
//		
//		u.setName("小王");
//		u.setBankAccount("123123123");
//		u.setUserID(null);
//		
//		UserDao.updateByExample(u);
//	}
	
	public void testdeletById() {
		UserDao.deletById(1,2,3);
	}
	
}
