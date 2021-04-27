package com.wangrui.bbt.dao;

import java.util.List;

import com.wangrui.bbt.beans.Goods;

public class GoodsDao {

	private static MybatisTemplate temp = new MybatisTemplate();
	
	public static int add(Goods g) {
		return temp.insert(Goods.class.getName()+".add", g);
	}
	
	public static Goods selectByID(int id) {
		return temp.selectOne(Goods.class.getName()+".selectByID", id);
	}
	
	public static List<Goods> selectLikeName(String name){
		return temp.selectList(Goods.class.getName()+".selectLikeName", name);
	}
}
