package com.hy.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.hy.springboot.mapper")
@SpringBootApplication
public class ThinkPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkPointApplication.class, args);
	}
}
