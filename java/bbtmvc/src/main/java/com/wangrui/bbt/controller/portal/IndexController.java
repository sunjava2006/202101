package com.wangrui.bbt.controller.portal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.bbt.beans.Type;
import com.wangrui.bbt.service.TypeService;

@Controller
public class IndexController {

	@Autowired
	private TypeService typeService;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Type> typeList = this.typeService.listAll();
		int count=1;
		List<List<Type>> list = new ArrayList<>();
		List<Type> li = new ArrayList<>();
		for(Type i : typeList) {
			if(count%3==0) {
				li = new ArrayList<>();
				list.add(li);
			}
			li.add(i);
			count++;
		}
		System.out.println(list);
		mv.addObject("typeList", list);
		
		return mv;
	}
	
	@RequestMapping("/validateCode")
	public void validateCode(OutputStream out, HttpSession session) throws IOException {
		BufferedImage img = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 20);
		
		String str = String.valueOf(Math.round(Math.random()*100000));
		session.setAttribute("code", str);
		
		g.setColor(Color.BLACK);
		g.drawString(str, 20, 15);
		
		ImageIO.write(img, "jpg", out);
		
		
	}
}
