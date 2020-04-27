package com.zshnb.ballplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zshnb.ballplatform.mapper")
public class BallPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BallPlatformApplication.class, args);
	}
}
