package com.wangrui.bbt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangrui.bbt.beans.Type;
import com.wangrui.bbt.service.TypeService;

@RestController
public class TypeController {
	
	
	@Autowired
	private TypeService typeService;

	@PostMapping("/addType")
	public Map add(Type type) {
		Map m = new HashMap();
		int count = this.typeService.add(type);
		if(1==count) {
			m.put("status", "ok");
		}else {
			m.put("status", "noOk");
		}
		return m;
	}
	
	@RequestMapping("/listType")
	public Map list(int currPage, int size) {
		Map m = new HashMap();
		List<Type> list = this.typeService.list(currPage, size);
		int totalCount = this.typeService.totalCount();
		int totalPage = this.typeService.totalPage(totalCount, size);
		m.put("list", list);
		m.put("totalCount", totalCount);
		m.put("totalPage", totalPage);
		m.put("currPage", currPage);
		return m;
	}
	
	@RequestMapping("/delType/{id}")
	public Map delType(@PathVariable("id")int id) {
		Map map = new HashMap();
		
		int count = this.typeService.del(id);
		if(1==count) {
			map.put("status", "ok");
		}
		else {
			map.put("status", "fail");
		}
		return map;
	}
	
	@RequestMapping("/updateType")
	public Map update(@RequestBody Type type) {
        Map map = new HashMap();
		
		int count = this.typeService.update(type);
		if(1==count) {
			map.put("status", "ok");
		}
		else {
			map.put("status", "fail");
		}
		return map;
	}
	
	@RequestMapping("/listAllType")
	public List<Type> listAllType(){
		return this.typeService.listAll();
	}
	
	
	
}
