package com.wangrui.bbt.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.wangrui.bbt.beans.User;
@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService us;
	
	@Test
	void testLogin() {
		User u = us.login("wang", "aaabbb");
		System.out.println(u);
		assertNotNull(u);
	}

}
