package com.wangrui.bbt.dao;

import com.wangrui.bbt.beans.OrderDetail;

import junit.framework.TestCase;

public class OrderDetailDaoTest extends TestCase {

	public void testSelectByID() {
		OrderDetail d = OrderDetailDao.selectByID(1);
		System.out.println(d);
		assertNotNull(d);
	}

}
