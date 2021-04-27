package com.wangrui.spring_base.aop.service;

import org.springframework.stereotype.Service;


public class PrintService {
	
	public void print() {
		System.out.println("你好.........");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void receive() {
		System.out.println("接收数据.........");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
