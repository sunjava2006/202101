package com.wangrui.blog.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.advance.jdbc.ConnectionUtil;
import com.wangrui.blog.beans.User;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class UserDAO {

	public static int add(String regName, String pwd, String email) throws SQLException {
		int count = -1;
		String sql = "insert into t_users "
				+ "values (seq_users.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm  = conn.prepareStatement(sql);
			stm.setString(1, regName);
			stm.setString(2, pwd);
			stm.setString(3, email);
			count = stm.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return count;
	}
	
	public static User findByRegNameAndPwd(String regName, String pwd) throws SQLException {
		User u = null;
		// 预编译语句对象可能防止“语句注入”。
		String sql = "select * from t_users where reg_name=? and pwd=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql); // 通过SQL语句创建预编译的语句对象
			stm.setString(1, regName); // 为预编译语句对象中的参数赋值。
			stm.setString(2, pwd);
			rst = stm.executeQuery(); // 执行语句
			while(rst.next()) {
				Integer userID = rst.getInt("user_id");
				String regname = rst.getString("reg_name");
				String PWD = rst.getString("pwd");
				String email = rst.getString("email");
				
				u = new User(userID, regname,PWD, email);
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return u;
	}
	
	
	
	public static void save(String regName, String pwd, String email) throws SQLException {
		Connection conn = null;
		CallableStatement stm = null;
		String sql = "{call p_add_user(?,?,?)}";
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareCall(sql);
			stm.setString(1, regName);
			stm.setString(2, pwd);
			stm.setString(3, email);
			
			stm.execute();
			
			
		} catch (SQLException e) {
			throw e;
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
	}
	
	public static boolean existRegName(String regName) throws SQLException {
		boolean exist = false;
		String sql = "call p_exist_name(?,?)";
		Connection conn = null;
		CallableStatement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareCall(sql);
			stm.setString(1, regName); // 为输入参数赋值
			stm.registerOutParameter(2, Types.INTEGER); // 注册输出参数
			stm.execute();
			
			exist = stm.getInt(2)>0? true : false ;
			
		} catch (SQLException e) {
			throw e;
		}finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		
		return exist;
	}
	
	public static List<User> list(int page, int size) throws SQLException{
		List<User> list = new ArrayList<>();
		
		String sql = "{call p_list_user(?,?,?)}";
		Connection conn = null;
		CallableStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareCall(sql);
			stm.setInt(1, page);
			stm.setInt(2, size);
			stm.registerOutParameter(3, OracleTypes.CURSOR);
			
			stm.execute();
			
			rst = ((OracleCallableStatement)stm).getCursor(3); // 获取游标
			
			while(rst.next()) {
				int userID = rst.getInt("user_id");
				String regName = rst.getString("reg_name");
				String pwd = rst.getString("pwd");
				String email = rst.getString("email");
				
				User u = new User(userID, regName, pwd, email);
				list.add(u);
			}
			
			
			
		} catch (SQLException e) {
			throw e;
		}finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
//		System.out.println(UserDAO.add("jack", "123456", "jack@qq.com"));
//		System.out.println(UserDAO.findByRegNameAndPwd("dfdasf' or 1=1--", "dfdfdf"));
		UserDAO.save("张明", "123456", "123@126.com");
		
//		System.out.println(UserDAO.existRegName("张明"));
		
		System.out.println(UserDAO.list(1, 2));
		System.out.println(UserDAO.list(2, 2));
	}
}
