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
		int count = -1; // ��executeUpdate ����-1��ʾ���ɹ���

		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			
			// 2�������ݿⷢ�����
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
			rst = stm.executeQuery(sql); // ������в���������ѯ�������ݣ���һ��ָ�루�α꣩��
			
			while(rst.next()) {
				int id = rst.getInt(1); // ȡ��һ�е�ֵ
				String stuname = rst.getString(2);
				String gender = rst.getString("gender"); // ͨ��������ȡֵ��
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
//		System.out.println(addStudent("����","Ů",null));

//		System.out.println(deleteStudent(55));
//		System.out.println(updateStudent("����", "Ů", new Date(), 54));
		System.out.println(query("Ton"));
	}
}
