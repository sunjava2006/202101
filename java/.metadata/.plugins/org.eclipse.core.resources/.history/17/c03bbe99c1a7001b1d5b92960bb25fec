package com.wangrui.bbt.dao.dynamic;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class GoodsSql {

	public String queryGoods(Map<String, Object> m) {
		Integer typeID  = (Integer) m.get("typeID");
		String goodsName = (String) m.get("goodsName");
		Float minPrice = (Float) m.get("minPrice");
		Float maxPrice  = (Float) m.get("maxPrice");
		String sqlStr = null;
		SQL sql = new SQL();
		
	
		sql.SELECT(" a.*, rownum ro ");
		sql.FROM("t_goods a");
		if(typeID != null) {
			sql.WHERE(" type_id = #{typeID}");
		}
		if(goodsName!=null ) {
			goodsName = "%"+goodsName+"%";
			m.put("goodsName",goodsName);
			System.out.println(goodsName);
			sql.AND();
			sql.WHERE("goods_name like #{goodsName}");
		}
		if(minPrice!=null && maxPrice!=null) {
			sql.AND();
			sql.WHERE("price between #{minPrice} and #{maxPrice}");
		}
		sql.AND();
		sql.WHERE("rownum <=#{max}");
		
		SQL s = new SQL();
		s.SELECT("*").FROM("("+sql.toString()+")").WHERE("ro >=#{min}");
		sqlStr = s.toString();
		return sqlStr;
	}
	
	public String queryGoodsCount(Map<String, Object> m) {
		Integer typeID  = (Integer) m.get("typeID");
		String goodsName = (String) m.get("goodsName");
		Float minPrice = (Float) m.get("minPrice");
		Float maxPrice  = (Float) m.get("maxPrice");
		String sqlStr = null;
		SQL sql = new SQL();
		
	
		sql.SELECT("count(*)");
		sql.FROM("t_goods a");
		if(typeID != null) {
			sql.WHERE(" type_id = #{typeID}");
		}
		if(goodsName!=null ) {
			goodsName = "%"+goodsName+"%";
			m.put("goodsName",goodsName);
			System.out.println(goodsName);
			sql.AND();
			sql.WHERE("goods_name like #{goodsName}");
		}
		if(minPrice!=null && maxPrice!=null) {
			sql.AND();
			sql.WHERE("price between #{minPrice} and #{maxPrice}");
		}

		sqlStr = sql.toString();
		return sqlStr;
	}
}
