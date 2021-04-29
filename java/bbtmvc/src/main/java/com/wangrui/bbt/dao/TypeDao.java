package com.wangrui.bbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.cache.Cache;

import com.wangrui.bbt.beans.Type;


@Mapper
@CacheNamespace()
public interface TypeDao {

	@SelectKey(before = true, keyColumn = "type_id", keyProperty = "typeID", 
			statement = "select seq_types.nextval from dual", resultType = Integer.class)
	@Insert(value = "insert into t_types values (#{typeID}, #{name})")
	public int add(Type type);
	
	
	
	@Results(id = "TypeResult", 
			value = {@Result(column = "type_id", property = "typeID", id = true),
					 @Result(column = "type_name", property = "name")
	                })
	@Select("select * from ( " + 
			"select a.*, rownum ro from " + 
			"(select * from t_types order by type_id desc)a"
			+ " where rownum<=${page*size})where ro>${(page-1)*size}")
	public List<Type> listOrderDesc(@Param("page")int page, @Param("size")int size);
	
	@Select("select count(*) from t_types")
	public int totalCount();
	
	
	@Delete("delete from t_types where type_id=#{id}")
	public int del(int id);
	
	@Select("select * from t_types where type_id=#{id}")
	@ResultMap("TypeResult")
	public Type selectByID(int id);
	
	@Update("update t_types set type_name=#{name} where type_id=#{typeID}")
	public int update(Type type);
	
	@Select("select * from t_types")
	@ResultMap("TypeResult")
	public List<Type> listAllType();
}
