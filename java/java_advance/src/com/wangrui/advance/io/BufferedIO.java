package com.wangrui.advance.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedIO {

	public static void write(String fileName, String charset, boolean appand, String msg) throws IOException {
		
		BufferedWriter bw = null;
		OutputStreamWriter ow = null;
		FileOutputStream fo = null;
		
		try {
			fo = new FileOutputStream(fileName, appand);
			ow = new OutputStreamWriter(fo, charset);
			bw = new BufferedWriter(ow, 1024);
			
			bw.write(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				bw.close();
			}
			if(ow != null) {
				ow.close();
			}
			if(fo != null) {
				fo.close();
			}
		}

	}
	
	
	public static String read(String fileName, String charset) throws IOException {
		StringBuffer sb = new StringBuffer();
		
		BufferedReader br = null;
		InputStreamReader ir = null;
		FileInputStream fi = null;
		
		try {
			fi = new FileInputStream(fileName);
			ir = new InputStreamReader(fi, charset);
			br = new BufferedReader(ir, 1024);
			String s = null;
			while(null != (s=br.readLine())) {
				sb.append(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fi!=null) {
				fi.close();
			}
			if(ir!=null) {
				ir.close();
			}
			if(br!=null) {
				br.close();
			}
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedIO.write("d://f.txt", "utf-8", false, "hello  ¿ΩÁ.");
		System.out.println(BufferedIO.read("d://f.txt", "utf-8"));
	}
}
