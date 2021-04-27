package com.wangrui.advance.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileWriterOperation {

	public static void writer(String file, String... msgs) throws IOException {
		
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(file);
			if(msgs != null) {
				for( String s: msgs) {
//					fwriter.append(s);
					fwriter.write(s);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != fwriter) {
				fwriter.close();
			}
		}
	}
	
	public static String read(String fileName) throws IOException {
		String s = null;
	    StringBuffer sb = new StringBuffer();
		// �ַ�������
		FileReader freader = null;
		try {
			freader = new FileReader(fileName);
			char[] buffer = new char[1024];
			int count = -1;
			while(-1 != (count = freader.read(buffer))) {
//				s += String.valueOf(buffer, 0, count);
				sb.append(buffer, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != freader) {
				freader.close();
			}
		}
		s = sb.toString();
		return s;
	}
	
	public static void write(String fileName, String charset, boolean appand, String...msgs) throws IOException {
		
		// ���ַ���ָ������������ļ��У�����Ҫ���Ž���
		OutputStreamWriter outWriter = null;
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(fileName, appand);
			outWriter = new OutputStreamWriter(out, charset);
			
			if(msgs != null) {
				for(String s: msgs) {
					outWriter.write(s);
				}
			}
			
		} catch (IOException  e) {
			e.printStackTrace();
		} finally {
			if(null != outWriter) {
				outWriter.close();
			}
			if(null != out) {
				out.close();
			}
		}
		
	}
	
	public static String read(String fileName, String charset) throws IOException {
		StringBuffer sb = new StringBuffer();
		// ��ָ����������ַ�����Ҫ���Ž���
		InputStreamReader inReader = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName);
			if(charset == null) {
				inReader = new InputStreamReader(in);
			}else {
				inReader = new InputStreamReader(in, charset);
			}
			
			char[] buffer  = new char[1024];
			int count = -1;
			while(-1 != (count=inReader.read(buffer))) {
				sb.append(buffer, 0, count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(inReader != null) {
				inReader.close();
			}
			if(in != null) {
				in.close();
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
//		FileWriterOperation.writer("d:\\c.txt", "We like Java.", "����Ҳϲ����ѧ��","����ϲ��Ӣ�");
		
		FileWriterOperation.write("d:\\d.txt", "utf-8", false, "We like Java.", "����Ҳϲ����ѧ��","����ϲ��Ӣ�");
		
		
		String s = FileWriterOperation.read("d:\\d.txt", "utf-8");
		
		System.out.println(s);
				
	}
}
