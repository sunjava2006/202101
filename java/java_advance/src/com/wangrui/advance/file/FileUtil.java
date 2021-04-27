package com.wangrui.advance.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {
	
	public static File create(String parent, String child) throws IOException {
		File dir = new File(parent);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File f = new File(parent, child);
		f.createNewFile();

		return f;
	}
	
	public static File create(String path) throws IOException {
		
		File f = new File(path);
		
		// 1、取这个文件的父目录，测试是否存在，不存在则创建一个。
		File parent = f.getParentFile(); // 取父目录文件对象
		System.out.println(parent.getAbsolutePath());  // 取文件的绝对路径名
		if(!parent.exists()) {
			parent.mkdirs();
		}
		
		// 2、在该目录下创建文件
		f.createNewFile();
		f.setReadable(true);

		return f;
	}
	
	

	public static void main(String[] args) throws IOException {
		
		
		File dir = new File("D:\\录频");
		
		String[] childName = dir.list();
		
		for(String s : childName) {
			System.out.println(s);
		}
		System.out.println("-----------------------");
		
		File[] children = dir.listFiles();
		for(File f: children) {
			System.out.println(f);
		}
		
		
		

	}
}
