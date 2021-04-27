package com.wangrui.advance.thread.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumer {
	static int sn = 1;

	public static void main(String[] args) {

		List list = new ArrayList();

		Thread producer = new Thread() {
			public void run() {
				try {
					while (true) {
						synchronized (list) {
							if (list.size() == 0) {
								for (int i = 0; i < 10; i++) {
									System.out.println("生产：" + sn);
									list.add(ProducerAndConsumer.sn++);
									Thread.sleep(200);
								}
							}

							list.notifyAll();
							list.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};

		Thread consumer = new Thread() {
			public void run() {

				try {
					while (true) {
						synchronized (list) {
							while (list.size() > 0) {
								Object o = list.remove(0);
								System.out.println("消费：" + o);
								Thread.sleep(200);
							}

							list.notifyAll();
							list.wait();
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		
		producer.start();
		consumer.start();

	}
}
