package com.wangrui.bbt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.wangrui.bbt.beans.User;

@Mapper
public interface UserDao {

	@Results(id = "userResult",
			 value = {@Result(column = "user_id", property = "userID", id = true),
					  @Result(column = "reg_name", property = "regName"),
					  @Result(column = "pwd", property = "pwd"),
					  @Result(column = "bank_account", property = "bankAccount"),
					  @Result(column = "real_name", property = "name")
	                 })
	@Select(value = "select * from t_users where reg_name=#{regName} and pwd=#{pwd}")
	public User login(@Param("regName") String regName,@Param("pwd") String pwd);
}
