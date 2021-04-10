package com.cxp.sbt;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//导入自定义配置文件
/*@ImportResource(locations = {""})*/
@SpringBootApplication
@MapperScan(basePackages = "com.cxp.sbt.mapper")
public class Springboottest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboottest1Application.class, args);
	}

}
