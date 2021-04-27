package com.wangrui.javabase.flow;

public class IfElIf {

	public static void main(String[] args) {

		int score = 90;//(int) (Math.round(Math.random() * 100));

		String grad = "";

		if (score >= 90) {
			grad = "优";
		} else if (score >= 80) {
			grad = "良";
		} else if (score >= 70) {
			grad = "中";
		} else if (score >= 60) {
			grad = "及格";
		} else {
			grad = "差";
		}

		System.out.println(score + grad);
		
		
		if(score>=90) {
			grad = "优";
		}
		if(score<90 && score>=80) {
			grad = "良";
		}
		if(score<80 && score>=70) {
			grad = "中";
		}
		if(score <70 && score>=60) {
			grad = "及格";
		}
		if(score<60) {
			grad = "差";
		}
		
		System.out.println(score + grad);
		
	}
}
