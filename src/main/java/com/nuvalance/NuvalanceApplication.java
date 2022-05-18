package com.nuvalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.*;

@SpringBootApplication
@EnableConfigurationProperties
public class NuvalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuvalanceApplication.class, args);
	}

}
