package com.wangrui.bbt.dao;

import com.wangrui.bbt.beans.Goods;
import com.wangrui.bbt.beans.Type;

import junit.framework.TestCase;

public class GoodsDaoTest extends TestCase {

//	public void testAdd() {
//		Goods g = new Goods(null, new Type(1,""),  "ipnone se", "台", 3200);
//		int c = GoodsDao.add(g);
//		assertEquals(c, 1);
//	}
	
//	public void testSelectById() {
//		Goods g = GoodsDao.selectByID(1);
//		System.out.println(g);
//		assertNotNull(g);
//	}
	
	public void testselectLikeName() {
		System.out.println(GoodsDao.selectLikeName("i"));
	}

}
