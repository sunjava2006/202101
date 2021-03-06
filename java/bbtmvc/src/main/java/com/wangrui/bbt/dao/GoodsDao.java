package com.wangrui.bbt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import com.wangrui.bbt.beans.Goods;
import com.wangrui.bbt.dao.dynamic.GoodsSql;

import ch.qos.logback.core.subst.Token.Type;

@Mapper
public interface GoodsDao {

	@SelectKey(before = true, keyColumn = "goods_id", keyProperty = "goodsID",
			resultType = Integer.class, statement = "select seq_goods.nextval from dual")
	@Insert("insert into t_goods values(#{goodsID}, #{type.typeID}, #{goodsName}, #{unit}, #{price}, #{photo})")
	public int add(Goods goods);
	
	@SelectProvider(value=GoodsSql.class, method = "queryGoods")
	@Results(id = "GoodsResult",
	         value = {@Result(column = "goods_id", property = "goodsID", id = true),
	        		  @Result(column = "goods_name", property = "goodsName"),
	        		  @Result(column = "unit", property = "unit"),
	        		  @Result(column = "price", property = "price"),
	        		  @Result(column = "photo", property = "photo"),
	                  @Result(column = "type_id", property = "type", javaType = Type.class, 
	                          one = @One(select = "com.wangrui.bbt.dao.TypeDao.selectByID")
	                		  )
	         
     	              })
	public List<Goods> query(Map map);
	
	@SelectProvider(value=GoodsSql.class, method = "queryGoodsCount")
	public int queryConditionCount(Map map);
	
	@Delete("delete t_goods where goods_id=#{id}")
	public int delByID(int id);
	
}
