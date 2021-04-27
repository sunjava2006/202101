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
//					if(Thread.interrupted()) { // ��̬��������⵱ǰ�߳��Ƿ��������жϱ�ǡ�����������ǡ�
//						System.out.println(Thread.interrupted());
//						break;
//					}
					if(Thread.currentThread().isInterrupted()) { // ʵ������������߳��Ƿ��������жϱ�ǡ�������������ǡ�
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
		
		// ��壬����JFrame�ϡ�
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.WHITE);
		this.setContentPane(panel); 
		
		txt = new JTextField();
		txt.setSize(300, 50);
		txt.setLocation(100, 100);
		Font f = new Font("����", Font.BOLD, 24);
		txt.setFont(f);
		txt.setEditable(false);
		panel.add(txt);
		
		
		
		JButton stopBtn = new JButton("ֹͣ");
		stopBtn.setSize(80, 50);
		stopBtn.setLocation(100, 200);
		panel.add(stopBtn);
		stopBtn.addActionListener((ActionEvent e)->{
			t.interrupt();
		});
		
		
		JButton suspendBtn = new JButton("��ͣ");
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
		
		JButton resumeBtn = new JButton("�ָ�");
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
