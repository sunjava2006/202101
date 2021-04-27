package com.wangrui.blog.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.blog.bean.Type;
import com.wangrui.blog.dao.TypeDao;

public class TypeService {

	public static List<Type> listAll(){
		List<Type> li = null;
		try {
			li = TypeDao.listAll();
		} catch (SQLException e) {
			e.printStackTrace();
			li = new ArrayList<>();
		}
		return li;
	}
}
