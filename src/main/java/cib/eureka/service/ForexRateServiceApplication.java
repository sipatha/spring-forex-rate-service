package cib.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ForexRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexRateServiceApplication.class, args);
	}

}
