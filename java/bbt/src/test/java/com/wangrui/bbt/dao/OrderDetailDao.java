package com.wangrui.bbt.dao;

import com.wangrui.bbt.beans.OrderDetail;

public class OrderDetailDao {

	private static  MybatisTemplate temp = new MybatisTemplate();
	
	public static OrderDetail selectByID(int id) {
		return temp.selectOne(OrderDetail.class.getName()+".selectByDetailID", id);
	}
}
