package com.example.usereventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(UserEventChannel.class)

public class UserEventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserEventServiceApplication.class, args);
	}
}
