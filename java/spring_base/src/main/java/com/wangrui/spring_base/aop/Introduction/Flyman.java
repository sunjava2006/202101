package com.wangrui.spring_base.aop.Introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Flyman {

	@DeclareParents(value = "com.wangrui.spring_base.aop.Introduction.Human",
			defaultImpl = Bird.class)
	Flyable human;
}
