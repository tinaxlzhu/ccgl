package com.ftkj.ccgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.ftkj.ccgl.mapper")//mybatis mapper扫描包
@SpringBootApplication
@EnableScheduling //开启定时任务
public class FtkjccglApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtkjccglApplication.class, args);
	}
}
