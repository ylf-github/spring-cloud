package com.ylf.serverthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerThreeApplication.class, args);
	}

}
