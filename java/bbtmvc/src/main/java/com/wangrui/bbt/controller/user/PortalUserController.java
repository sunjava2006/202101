package com.wangrui.bbt.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangrui.bbt.beans.User;
import com.wangrui.bbt.service.UserService;

@Controller
@RequestMapping("/user")
public class PortalUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Map login(String regName, String pwd, String code, 
			HttpSession session, HttpServletResponse res) throws IOException {
		Map m = new HashMap();
		Object o = session.getAttribute("code");
		if(o!=null) {
			String sessCode = (String) o;
			if(sessCode.equals(code)) {
				boolean regNameOk = Pattern.compile("^\\w{6,20}$").matcher(regName).matches();
				boolean pwdOk = Pattern.compile("^[a-zA-Z0-9]{6}$").matcher(pwd).matches();
				String msg = "";
				if(!regNameOk) {
					msg += "用户名格式不正确。";
				}
				if(!pwdOk) {
					msg += "用户名格式不正确。";
				}
				if(regNameOk && pwdOk) {
					User u = userService.login(regName, pwd);
					if(u!=null) {
						session.setAttribute("userInfo", u);
						m.put("login", "ok");
					}
					else {
						m.put("msg", "用户名或密码不正确，重试。");
						m.put("login", "fail");
					}
				}
				else {
					m.put("login", "fail");
					m.put("msg", msg);
				}
			}else {
				m.put("msg", "验证码不正确");
				m.put("login", "fail");
			}
			
		}else {
			res.sendRedirect("/login.html");
			return null;
		}

		return m;
	}

}
