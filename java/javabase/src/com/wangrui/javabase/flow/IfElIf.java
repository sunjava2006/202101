package com.wangrui.javabase.flow;

public class IfElIf {

	public static void main(String[] args) {

		int score = 90;//(int) (Math.round(Math.random() * 100));

		String grad = "";

		if (score >= 90) {
			grad = "��";
		} else if (score >= 80) {
			grad = "��";
		} else if (score >= 70) {
			grad = "��";
		} else if (score >= 60) {
			grad = "����";
		} else {
			grad = "��";
		}

		System.out.println(score + grad);
		
		
		if(score>=90) {
			grad = "��";
		}
		if(score<90 && score>=80) {
			grad = "��";
		}
		if(score<80 && score>=70) {
			grad = "��";
		}
		if(score <70 && score>=60) {
			grad = "����";
		}
		if(score<60) {
			grad = "��";
		}
		
		System.out.println(score + grad);
		
	}
}
