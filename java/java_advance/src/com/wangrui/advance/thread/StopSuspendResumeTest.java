package com.wangrui.advance.thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StopSuspendResumeTest extends JFrame{
	
	JTextField txt = null;
	
	private Runnable runnable = new Runnable() {
		public void run() {
			SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				while(true) {
					Date now = new Date();
					String strTime = smt.format(now);
					txt.setText(strTime);
//					if(Thread.interrupted()) { // 静态方法，检测当前线程是否设置了中断标记。会清除这个标记。
//						System.out.println(Thread.interrupted());
//						break;
//					}
					if(Thread.currentThread().isInterrupted()) { // 实例方法，检测线程是否设置了中断标记。不会清除这个标记。
						System.out.println(Thread.interrupted());
						break;
					}
					Thread.sleep(1000);
				}
			} catch (Exception e) {
//				e.printStackTrace();
			} 
		}
	};

	Thread t = new Thread(runnable);
	
	public StopSuspendResumeTest() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 面板，补在JFrame上。
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		this.setContentPane(panel); 
		
		txt = new JTextField();
		txt.setSize(300, 50);
		txt.setLocation(100, 100);
		Font f = new Font("宋体", Font.BOLD, 24);
		txt.setFont(f);
		txt.setEditable(false);
		panel.add(txt);
		
		
		
		JButton stopBtn = new JButton("停止");
		stopBtn.setSize(80, 50);
		stopBtn.setLocation(100, 200);
		panel.add(stopBtn);
		stopBtn.addActionListener((ActionEvent e)->{
			t.interrupt();
		});
		
		
		JButton suspendBtn = new JButton("暂停");
		suspendBtn.setSize(80, 50);
		suspendBtn.setLocation(200, 200);
		panel.add(suspendBtn);
		suspendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				t.suspend();
				t.interrupt();
				
			}
		});
		
		JButton resumeBtn = new JButton("恢复");
		resumeBtn.setSize(80, 50);
		resumeBtn.setLocation(300, 200);
//		resumeBtn.setEnabled(false);
		panel.add(resumeBtn);
		resumeBtn.addActionListener((e)->{
//			t.resume();
			if(t.getState()==Thread.State.TERMINATED) {
				t = new Thread(runnable);
				t.start();
			}
			
		});

		this.setSize(1000, 800);
		this.setVisible(true);
		
		
		t.start();
		
        
	}
	
	public static void main(String[] args) {
		StopSuspendResumeTest f = new StopSuspendResumeTest();
	}
	
}
