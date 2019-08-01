package com.ylf.servertwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerTwoApplication.class, args);
	}

}
