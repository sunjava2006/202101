package com.wangrui.spring_base.aop.jdkproxy;

public class ServiceImpl implements Service {

	@Override
	public void service() {
		System.out.println("=======service==========");
	}

}
