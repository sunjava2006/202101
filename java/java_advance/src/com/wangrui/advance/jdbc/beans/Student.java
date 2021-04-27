package com.wangrui.advance.jdbc.beans;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{

	private Integer studentID;
	private String studentName;
	private String gender;
	private Date birthDate;
	
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Student() {
		
	}
	public Student(Integer studentID, String studentName, String gender, Date birthDate) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	
	
	
}
