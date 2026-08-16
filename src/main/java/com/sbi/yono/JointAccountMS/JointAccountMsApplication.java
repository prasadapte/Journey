package com.sbi.yono.JointAccountMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JointAccountMsApplication {

	public static void main(String[] args) {	
		SpringApplication.run(JointAccountMsApplication.class, args);
		System.out.println("Running.....");
	}

}
