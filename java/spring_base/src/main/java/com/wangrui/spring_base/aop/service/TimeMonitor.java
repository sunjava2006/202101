package com.wangrui.spring_base.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


public class TimeMonitor {


	public void monitor(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------------------");
		long start = System.currentTimeMillis();
		
		pjp.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end-start)+"毫秒");
	}
}
