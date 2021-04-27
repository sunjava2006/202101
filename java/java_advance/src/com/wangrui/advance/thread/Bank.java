package com.wangrui.advance.thread;

public class Bank {

	public  void save(Account a, int amount) {
		synchronized (a) {
			int aa = a.getAmount();
			aa += amount;
			a.setAmount(aa);
		}
		
	}

	public int get(Account a, int amount) {
		synchronized (a) {
			System.out.println("------------------------");
			if (a.getAmount() >= amount) {
				a.setAmount(a.getAmount() - amount);
				System.out.println("=========================");
				return amount;
			}
			System.out.println("=========================");
			return 0;
			
		}

	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		Account a = new Account(119110, 1000);
		Account a2 = new Account(119111, 1000);

		Runnable rget = () -> {
			System.out.println(bank.get(a, 900));
		};

		Runnable rget2 = () -> {
			System.out.println(bank.get(a2, 900));
		};
		
		Thread t = new Thread(rget);
		Thread t2 = new Thread(rget2);

		t.start();
		t2.start();

		byte b = (byte)999;
		
	}
}
