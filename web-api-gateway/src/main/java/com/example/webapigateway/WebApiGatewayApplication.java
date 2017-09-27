package com.example.webapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@IntegrationComponentScan
@EnableBinding(MessageChannels.class)
@EnableZuulProxy
@EnableCircuitBreaker

public class WebApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApiGatewayApplication.class, args);
	}

}
