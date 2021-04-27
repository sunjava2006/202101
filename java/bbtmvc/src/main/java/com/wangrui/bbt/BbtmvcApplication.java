package com.wangrui.bbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// SpringBoot启动器类
@SpringBootApplication
//@ComponentScan()
public class BbtmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbtmvcApplication.class, args);
	}

}
