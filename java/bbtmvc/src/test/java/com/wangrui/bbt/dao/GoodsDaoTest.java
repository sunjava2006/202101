package com.wangrui.bbt.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class GoodsDaoTest {

	@Autowired
	private GoodsDao dao;
	
	//@Test
	void testQuery() {
		Map map = new HashMap();
//		map.put("typeID", 1);
//		map.put("goodsName", "ipnone");
		map.put("minPrice", 1f);
		map.put("maxPrice", 30000f);
		map.put("min", 0);
		map.put("max", 2);
		System.out.println(dao.query(map));
		System.out.println("================================");
	}
	
	@Test
	void testQueryGoodsCount() {
		Map map = new HashMap();
		map.put("typeID", 1);
//		map.put("goodsName", "ipnone");
		map.put("minPrice", 1f);
		map.put("maxPrice", 30000f);
		map.put("min", 0);
		map.put("max", 2);
		System.out.println(dao.queryConditionCount(map));
		System.out.println("================================");
	}
}
