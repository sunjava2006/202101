package com.wangrui.javabase.oop;

public class Student extends People{

	public int studentID;
	public String schoolName;
	
	{
		System.out.println();
	}
	
	public Student() {
		this("female");
	}
	
    public Student(String gender) {
		super(gender);
	}
    
  
	
	public Student(String name, String gender, String birthDate, float h) {
		super(gender);
		super.name = name;
		super.birthDate = birthDate;
		this.height = h;
		
	}
	
	public Student(int studentID, String schoolName) {
		this.studentID = studentID;
		this.schoolName = schoolName;
		
	}
	

	public Student(String name, String gender, String birthDate, float h, int studentID, String schoolName) {
		super(name, gender, birthDate, h);
		this.studentID = studentID;
		this.schoolName = schoolName;
		
	}

	public void study() {
		System.out.println(this.name + "学习中...........");
	}
	
	@Override // 方法重写
	public Object work() {
		return "学习成果";
	}
	
    // 方法重载
	public int work(Object o) {
		 System.out.println(this.work());
		 System.out.println(super.work());
         return 10;
	}
	
	public static void main(String[] args) {
		
		People p ;
		int ran = (int)(Math.random()*10);
		if(ran%2==0) {
			p = new Student();
		}else {
			p = new Teacher();
		}
		
		System.out.println(p.work());
		
		p.sleep();
		if(p instanceof Student) {
			Student s = (Student) p;
			s.study();
		}else {
			Teacher t = (Teacher) p;
			t.teach();
		}
		
	}
}
