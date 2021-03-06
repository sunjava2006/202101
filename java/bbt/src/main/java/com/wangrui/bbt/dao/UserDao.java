package com.wangrui.bbt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wangrui.bbt.beans.User;

public class UserDao {

	private static MybatisTemplate temp = new MybatisTemplate();
	
	public static User selectByUserIdWithOrders(int id) {
		return temp.selectOne(User.class.getName()+".selectByUserIdWithOrders", id);
	}
	
	
	public static int addUser(User u) {

		return temp.insert(User.class.getName()+".add", u);

	}
	
	public static int delete(int id) {
		return temp.delete(User.class.getName()+".deleteByID", id);
	}
	
	public static User login(String regName, String pwd) {
		
		Map<String,String> map = new HashMap<>();
		map.put("regName", regName);
		map.put("pwd", pwd);
		return temp.selectOne(User.class.getName()+".login", map);
		
	}
	
	public static List<User> list(int page, int size){
		
		Map<String, Integer> map = new HashMap<>();
		map.put("page", page);
		map.put("size", size);
		return temp.selectList(User.class.getName()+".list", map);
		
	}

	public static List<Map> groupByGender(){
		
		   return temp.selectList(User.class.getName()+".groupByGender");
			
	}
	
	public static List<Map> SelectByRegName(String regName){
		return temp.selectList(User.class.getName()+".selectByRegName", regName);
							
	}
	
	
	public static int totalCount() {
		return temp.selectOne(User.class.getName()+".totalCount");
		
	}
	
	public static int updatePWd(User u) {
		return temp.update(User.class.getName()+".updatePwd", u);
			
	}
	
	public static List<User> selectByExample(User u){
		return temp.selectList(User.class.getName()+".selectByExample", u);
	}
	
	public static int updateByExample(User u) {
		return temp.update(User.class.getName()+".updateByExample", u);
	}
	
	public static int deletById(int... ids) {
		return temp.delete(User.class.getName()+".deleteByIDs", ids);
		
	}
}
