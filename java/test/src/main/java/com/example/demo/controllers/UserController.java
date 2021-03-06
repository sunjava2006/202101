package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;

@RestController
public class UserController {

	@RequestMapping(value="/login", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public Map login(@RequestBody() User user, HttpSession session) {
		session.setAttribute("userInfo", user);
		System.out.println("------------------");
		Map  m = new HashMap();
		System.out.println(user);
		m.put("status", "ok");
		return m;
	}
}
