package com.wangrui.bbt.dao;

import com.wangrui.bbt.beans.Order;

import junit.framework.TestCase;

public class OrderDaoTest extends TestCase {

	public void testSelectByID() {
		Order o = OrderDao.selectByID(1);
		System.out.println(o);
		assertNotNull(o);
	}

}
