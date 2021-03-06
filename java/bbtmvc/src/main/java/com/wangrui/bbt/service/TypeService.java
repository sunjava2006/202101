package com.wangrui.bbt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.bbt.beans.Type;
import com.wangrui.bbt.dao.TypeDao;

@Service
public class TypeService {

	@Autowired
	private TypeDao typeDao;
	
	public int add(Type type) {
		return this.typeDao.add(type);
	}
	
	public List<Type> list(int page, int size){
		return this.typeDao.listOrderDesc(page, size);
	}
	
	public int totalCount() {
		return this.typeDao.totalCount();
	}
	
	public int totalPage(double totalCount, int size) {
		return (int)Math.ceil(totalCount/size);
	}
	
	public int del(int id) {
		return this.typeDao.del(id);
	}
	
	public int update(Type type) {
		return this.typeDao.update(type);
	}
	
	public List<Type> listAll(){
		return this.typeDao.listAllType();
	}
}
