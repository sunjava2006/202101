package com.wangrui.advance.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOperation {


	public static void write(String msg, String filePath, boolean appand, String charset) throws IOException {
		
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filePath, appand);  // 创建输出流
			
			// 写入字节内容
			byte[] data = msg.getBytes(charset);
			fout.write(data);
			fout.flush(); // 清空输出缓冲区
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fout.close(); // 关闭输出流
		}
		
	}

	
	public static String read(String filePath) throws IOException {
        String str = null;
		StringBuffer sb = new StringBuffer();
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(filePath);
			System.out.println(fin.available()); // 测试还能读出多少字节
			byte[] buffer = new byte[10]; // 构建缓冲区 ??????
			
			int count = -1;
			while(-1 != (count=fin.read(buffer))) {// 将数据读入缓冲区
				sb.append(new String(buffer, 0, count));
			}
			
			str = new String(buffer);  // 将缓冲区字节数组，转化为字符串
			
			System.out.println(Arrays.toString(buffer));
			System.out.println(str);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fin.close(); // 关闭输入流
		}
		
		str = sb.toString();
		return str;
	}
	
	public static void copy(String source, String target) throws IOException {
		// 1、判断源文件是否存在，如果存在进行copy， 不存在抛出异常。
		File sourceFile = new File(source);
		if(sourceFile.exists()) { 
			// 1.1 判断目标文件的目录是否存在，不存在创建一个。
			File targetFile = new File(target);
			File parentDir = targetFile.getParentFile();
			if(!parentDir.exists()) {
				parentDir.mkdirs();
			}
			// 1.2 copy操作，一边读源文件，一边写入目标文件。
			FileInputStream fin = null;
			FileOutputStream fout = null;
			try {
				fin = new FileInputStream(sourceFile);
				fout = new FileOutputStream(targetFile);
				
				// 缓冲1M
				byte[] buffer = new byte[1024*1024];
				int count = -1;
				
		        // 边读边写（读的方法返回这次读到的字节数，返回-1表示读完了）
				while(-1 != (count=fin.read(buffer))) {
					fout.write(buffer, 0, count);
				}

				
			} catch (IOException e) {
				throw e;
			} finally {
				if(fin!=null) {
					fin.close();
				}
				if(fout != null) {
					fout.close();
				}
			}
			
			
			
		}else {
			throw new FileNotFoundException("源文件不存在");
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
//		FileOperation.copy("D:\\录频\\bandicam 2021-03-24 09-08-07-876.mp4", "D:\\a.mp4");
               String s = FileOperation.read("d:\\c.txt");
		
		       System.out.println(s);
	}
}
