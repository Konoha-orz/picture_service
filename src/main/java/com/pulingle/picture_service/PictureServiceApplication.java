package com.pulingle.picture_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.pulingle.picture_service.mapper")
public class PictureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PictureServiceApplication.class, args);
	}
}
