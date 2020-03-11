package com.stadline.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.stadline.demo")
@EnableAspectJAutoProxy
public class StadlineDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StadlineDemoApplication.class, args);
	}
	

}
