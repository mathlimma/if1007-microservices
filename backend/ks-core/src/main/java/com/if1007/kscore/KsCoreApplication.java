package com.if1007.kscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class KsCoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(KsCoreApplication.class, args);
	}
}
