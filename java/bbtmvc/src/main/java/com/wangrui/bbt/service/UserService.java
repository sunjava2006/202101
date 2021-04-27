package com.wangrui.bbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.bbt.beans.User;
import com.wangrui.bbt.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User login (String regName, String pwd) {
		return this.userDao.login(regName, pwd);
	}
}
