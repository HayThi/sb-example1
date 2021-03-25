package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Value("${spring.application.name}")
	private String name;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		logger.info("This is info message {} {}", 10, 60);
		logger.warn("This is warn message");
		logger.error("This is error message");
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		System.out.println("test1");
		logger.info("This is info message {} {}", 10, 60);
		logger.warn("This is warn message");
		logger.error("This is error message");
		return name;
//		return "Hello World from Gradle";
	}

}