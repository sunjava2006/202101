package com.wangrui.advance.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.advance.jdbc.beans.Student;

public class StudentDAO {

	public static List<Student> queryByName(String name) throws SQLException{
		List<Student> list = new ArrayList<>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		String sql = "select * from student where student_name='"+name+"'";
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);
			while(rst.next()) {
				int studentID = rst.getInt("student_id");
				String studentName = rst.getString("student_name");
			    String gender = rst.getString("gender");
			    Date birthDate = rst.getDate("birth_date");
			    
			    Student s = new Student(studentID, studentName, gender, birthDate);
			    list.add(s);
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
	
	
	public static void deleteStudent(int id) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		String sql1 = "delete from score where student_id="+id;
		String sql2 = "delete from student where student_id="+id;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false); // 不让JDBC自动提交事务。
			stm = conn.createStatement();
			
			// 多条语句添加到“批处理”中，多条语句一次性提交给数据库去执行。
			stm.addBatch(sql1);
			stm.addBatch(sql2);
			stm.executeBatch(); // 执行批处理。

			
//			stm.clearBatch();
			
			conn.commit(); // 提交事务。
			
		} catch (SQLException e) {
			conn.rollback(); // 回滚事务。
			throw e;
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true); 
				conn.close();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		StudentDAO.deleteStudent(2);
		
	}
}
