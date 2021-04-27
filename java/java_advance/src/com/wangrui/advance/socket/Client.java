package com.wangrui.advance.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket s = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader bfReader = null;
		try {
			s = new Socket();
			s.connect(new InetSocketAddress("127.0.0.1", 9095));
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			in = s.getInputStream();
			inReader = new InputStreamReader(in, "utf-8");
			bfReader = new BufferedReader(inReader);
			
			outWriter.write("hello,Äã³ÔÁËÂð£¿\n");
			outWriter.write("exit\n");
			outWriter.flush();
			
			String str = null;
			while(true) {
				str = bfReader.readLine();
				System.out.println(str);
				if(str.equals("exit")) {
					break;
				}
			}
			
			
			System.out.println("==========================");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outWriter.close();
			out.close();
			inReader.close();
			in.close();
			s.close();
		}
		
	}
}
