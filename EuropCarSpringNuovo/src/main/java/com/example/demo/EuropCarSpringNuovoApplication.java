package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EuropCarSpringNuovoApplication {

	public static void main(String[] args) {
//		 System.setProperty("server.port","8086");
//	        System.setProperty("server.tomcat.max-threads","200");
//	        System.setProperty("server.connection-timeout","60000");
		SpringApplication.run(EuropCarSpringNuovoApplication.class, args);
		
	}

}
