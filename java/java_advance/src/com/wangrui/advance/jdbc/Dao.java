package com.wangrui.advance.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Dao {
	
	public static int addStudent(String name, String gender, Date birthDate) 
			throws ClassNotFoundException, SQLException {
		int count = -1; // 在executeUpdate 返回-1表示不成功。

		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			
			// 2、向数据库发送语句
			stm = conn.createStatement();
			String sql = "";
			if(null == birthDate) {
				sql = "insert into student(student_id,student_name,gender)values(seq_stu.nextval,'"+name+"','"+gender+"')";
			}else {
				String d = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
				sql = "insert into student(student_id,student_name,gender,birth_date)"
						+ "values(seq_stu.nextval,'"+name+"','"+gender+"',to_date('"+d+"','yyyy-mm-dd'))";
			}
			
			count = stm.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
			conn.close();
		}
		
		return count;
	}
	
	public static int deleteStudent(int id) throws ClassNotFoundException, SQLException {
		int count = -1;

		Connection conn = null;
		Statement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			String sql = "delete from student where student_id="+id;
			count = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
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

	public static int updateStudent(String name, String gender, Date birthDate, int id) throws ClassNotFoundException, SQLException {
		int count = -1;

		Connection conn = null;
		Statement stm = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			String d = new SimpleDateFormat("yyyy-MM-dd").format(birthDate);
			String sql = "update student set student_name='"+name+"', gender='"+gender+"',"
					+ " birth_date=to_date('"+d+"','yyyy-mm-dd') where student_id="+id;
			count = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public static List<Map<String,Object>> query(String name) throws SQLException{
		List<Map<String,Object>> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		String sql = "select * from student where student_name='"+name+"'";
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql); // 结果集中并不包含查询出的数据，有一个指针（游标）。
			
			while(rst.next()) {
				int id = rst.getInt(1); // 取第一列的值
				String stuname = rst.getString(2);
				String gender = rst.getString("gender"); // 通过列名来取值。
				Date b = rst.getDate("birth_date");
				
				Map<String, Object> map = new HashMap<>();
				map.put("studentID", id);
				map.put("studentName", stuname);
				map.put("gender", gender);
				map.put("birthDate", b);
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		System.out.println(addStudent("王芬","女",null));

//		System.out.println(deleteStudent(55));
//		System.out.println(updateStudent("阿宁", "女", new Date(), 54));
		System.out.println(query("Ton"));
	}
}
