package com.wangrui.advance.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket sver = null;
		Socket s = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedReader bfReader = null;
		try {
			sver = new ServerSocket();
			sver.bind(new InetSocketAddress(9095));
			s = sver.accept(); // 监听绑定的端口上有没有用户发送来的连接。是阻塞的，直到有连接进来。
			in = s.getInputStream();
			inReader = new InputStreamReader(in, "utf-8");
			bfReader = new BufferedReader(inReader);
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			
			String str = null;
			while(true) {
				str = bfReader.readLine();
			    System.out.println(str);
			    if(str.equals("exit")) {
			    	break;
			    }
			}
			
			
			System.out.println("------------------------");
					
			
			outWriter.write("我吃过了。\n");
			outWriter.write("exit\n");
			outWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outWriter.close();
			out.close();
			inReader.close();
			in.close();
			s.close();
			sver.close();
		}
		
	}
}
