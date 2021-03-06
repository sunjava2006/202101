package com.wangrui.bbt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import com.wangrui.bbt.beans.User;
import com.wangrui.bbt.service.UserService;

@Controller
public class UserController {
DispatcherServlet ss;

	@Autowired
	private UserService us;
	
//	@RequestMapping(value="/login", method = {RequestMethod.POST})
	@PostMapping("/login")
	@ResponseBody
//	@CrossOrigin(value = {"http://localhost:8086","http://localhost:8087"})
	@CrossOrigin("*")
	public Map login(@RequestParam("regName")String name, String pwd,
			         HttpSession session,
			         HttpServletResponse response) {
		System.out.println("/login");
		Map map = new HashMap();
		
		User u = us.login(name, pwd);
		if(null != u) {
			session.setAttribute("userInfo", u);
			map.put("status", "ok");
		}else {
			map.put("status", "noOk");
		}
		
//		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return map;
	}
}
