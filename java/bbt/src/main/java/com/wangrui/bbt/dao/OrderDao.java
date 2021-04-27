package com.wangrui.bbt.dao;

import com.wangrui.bbt.beans.Order;

public class OrderDao {

	private static MybatisTemplate temp = new MybatisTemplate();
	
	public static Order selectByID(int id) {
		return temp.selectOne(Order.class.getName()+".selectByID", id);
	}
}
