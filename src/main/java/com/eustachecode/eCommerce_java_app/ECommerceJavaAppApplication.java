package com.eustachecode.eCommerce_java_app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.eustachecode.eCommerce_java_app.mappers")
public class ECommerceJavaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceJavaAppApplication.class, args);
	}

}
