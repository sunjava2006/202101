package com.wangrui.bbt.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wangrui.bbt.beans.Goods;
import com.wangrui.bbt.beans.Type;
import com.wangrui.bbt.service.GoodsService;

@RestController
public class GoodsController {

	@Value("${fileUpload}")
	private String fileUploadPath;
	
	@Autowired
	private GoodsService goodsService;
	
	@PostMapping("/addGoods")
	public Map addGoods(MultipartFile photo, int typeID, String goodsName, String unit, float price) throws IllegalStateException, IOException {
		Map m = new HashMap();
		String oldName = photo.getOriginalFilename();
		String newName = System.currentTimeMillis()+oldName.substring(oldName.lastIndexOf("."));
		File f = new File(this.fileUploadPath, newName);
		photo.transferTo(f);
		
		Goods g = new Goods(null, new Type(typeID,null), goodsName, unit, price, newName);
		
		int count = this.goodsService.add(g);
		if(1==count) {
			m.put("status", "ok");
		}else {
			m.put("status", "fail");
		}
	
		return m;
	}
	
	@PostMapping("/queryGoods")
	public Map query(Integer typeID, String goodsName,  Float minPrice, 
			Float maxPrice,  Integer currPage, Integer size) {
		Map map = new HashMap();
		System.out.println(typeID);
		System.out.println(goodsName);
		System.out.println(minPrice);
		System.out.println(maxPrice);
		
		if(currPage==null) {
			currPage = 1;
		}
		if(size == null ) {
			size = 10;
		}
		map.put("typeID", typeID);
		map.put("goodsName", goodsName);
		map.put("minPrice", minPrice);
		map.put("maxPrice", maxPrice);
		map.put("min", (currPage-1)*size);
		map.put("max", currPage*size);
		
		List<Goods> list = this.goodsService.query(map);
		int totalCount = this.goodsService.queryConditionCount(map);
		int totalPage = this.goodsService.totalPage(totalCount, size);
		
		map.put("goodsList", list);
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("currPage", currPage);
		
		
		return map;
	}
	
	@RequestMapping("/delGoods")
	public Map del(@RequestParam("goodsID") int id) {
		Map m = new HashMap();

		int count = this.goodsService.delByID(id);
		if(1==count) {
			m.put("status", "ok");
		}else {
			m.put("status", "fail");
		}
	
		return m;
	}
	
}
