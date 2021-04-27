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
			fout = new FileOutputStream(filePath, appand);  // ���������
			
			// д���ֽ�����
			byte[] data = msg.getBytes(charset);
			fout.write(data);
			fout.flush(); // ������������
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fout.close(); // �ر������
		}
		
	}

	
	public static String read(String filePath) throws IOException {
        String str = null;
		StringBuffer sb = new StringBuffer();
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(filePath);
			System.out.println(fin.available()); // ���Ի��ܶ��������ֽ�
			byte[] buffer = new byte[10]; // ���������� ??????
			
			int count = -1;
			while(-1 != (count=fin.read(buffer))) {// �����ݶ��뻺����
				sb.append(new String(buffer, 0, count));
			}
			
			str = new String(buffer);  // ���������ֽ����飬ת��Ϊ�ַ���
			
			System.out.println(Arrays.toString(buffer));
			System.out.println(str);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fin.close(); // �ر�������
		}
		
		str = sb.toString();
		return str;
	}
	
	public static void copy(String source, String target) throws IOException {
		// 1���ж�Դ�ļ��Ƿ���ڣ�������ڽ���copy�� �������׳��쳣��
		File sourceFile = new File(source);
		if(sourceFile.exists()) { 
			// 1.1 �ж�Ŀ���ļ���Ŀ¼�Ƿ���ڣ������ڴ���һ����
			File targetFile = new File(target);
			File parentDir = targetFile.getParentFile();
			if(!parentDir.exists()) {
				parentDir.mkdirs();
			}
			// 1.2 copy������һ�߶�Դ�ļ���һ��д��Ŀ���ļ���
			FileInputStream fin = null;
			FileOutputStream fout = null;
			try {
				fin = new FileInputStream(sourceFile);
				fout = new FileOutputStream(targetFile);
				
				// ����1M
				byte[] buffer = new byte[1024*1024];
				int count = -1;
				
		        // �߶���д�����ķ���������ζ������ֽ���������-1��ʾ�����ˣ�
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
			throw new FileNotFoundException("Դ�ļ�������");
		}
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
//		FileOperation.copy("D:\\¼Ƶ\\bandicam 2021-03-24 09-08-07-876.mp4", "D:\\a.mp4");
               String s = FileOperation.read("d:\\c.txt");
		
		       System.out.println(s);
	}
}
