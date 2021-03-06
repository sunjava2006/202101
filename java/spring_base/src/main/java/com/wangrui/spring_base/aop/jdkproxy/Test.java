package com.wangrui.spring_base.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.logging.LogSource;

public class Test {

	public static void main(String[] args) {
		
		ServiceImpl impl = new ServiceImpl();
		LogAspect logaspect = new LogAspect();
		Service service  = (Service)Proxy.newProxyInstance(impl.getClass().getClassLoader(), 
				                                           impl.getClass().getInterfaces(), new InvocationHandler() {
															
															@Override
															public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
																logaspect.printLog();
																impl.service();
																return null;
															}
														});
		
		service.service();
	}
}
