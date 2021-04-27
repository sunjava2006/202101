package com.wangrui.blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.blog.bean.Type;



public class TypeDao {

	public static List<Type> listAll() throws SQLException{
		List<Type> list = null;
		String sql = "select * from t_types";
		ResultSetExtractor<List<Type>> ext = (rst)->{
			List<Type> li = new ArrayList<>();
			while(rst.next()) {
				Integer typeID = rst.getInt(1);
				String type = rst.getString(2);
				
				Type t = new Type(typeID, type);
				li.add(t);
			}
			return li;
			
		};
		
		list = JdbcTemplate.select(sql, ext, null);
		return list;
	}
}
