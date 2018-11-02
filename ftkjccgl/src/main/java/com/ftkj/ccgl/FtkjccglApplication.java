package com.ftkj.ccgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ftkj.ccgl.mapper")//mybatis mapper扫描包
@SpringBootApplication
public class FtkjccglApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtkjccglApplication.class, args);
	}
}
