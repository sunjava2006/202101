package com.wangrui.bbt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.bbt.beans.Goods;
import com.wangrui.bbt.dao.GoodsDao;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	public int add(Goods goods) {
		return this.goodsDao.add(goods);
	}
	
	public List<Goods> query(Map map){
		return this.goodsDao.query(map);
	}
	
	public int queryConditionCount(Map map) {
		return this.goodsDao.queryConditionCount(map);
	}
	
	public int totalPage(double totalCount, int size) {
		return (int)Math.ceil(totalCount/size);
	}
	
	public int delByID(int id) {
		return this.goodsDao.delByID(id);
	}
}
