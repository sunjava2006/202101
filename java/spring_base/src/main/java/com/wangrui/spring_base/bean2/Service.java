package com.wangrui.spring_base.bean2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@org.springframework.stereotype.Service
public class Service {
	
	@PostConstruct
	public void init() {
		System.out.println("-----init-------");
	}
	
	public void service() {
		System.out.println("-----service-------");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("-----destory-------");
	}

}
