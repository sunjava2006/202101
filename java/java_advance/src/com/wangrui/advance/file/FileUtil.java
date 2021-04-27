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
		
		// 1��ȡ����ļ��ĸ�Ŀ¼�������Ƿ���ڣ��������򴴽�һ����
		File parent = f.getParentFile(); // ȡ��Ŀ¼�ļ�����
		System.out.println(parent.getAbsolutePath());  // ȡ�ļ��ľ���·����
		if(!parent.exists()) {
			parent.mkdirs();
		}
		
		// 2���ڸ�Ŀ¼�´����ļ�
		f.createNewFile();
		f.setReadable(true);

		return f;
	}
	
	

	public static void main(String[] args) throws IOException {
		
		
		File dir = new File("D:\\¼Ƶ");
		
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
