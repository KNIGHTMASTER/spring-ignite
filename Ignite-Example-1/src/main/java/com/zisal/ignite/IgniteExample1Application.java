package com.zisal.ignite;

import org.apache.ignite.Ignition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
public class IgniteExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(IgniteExample1Application.class, args);
		Ignition.start(ApacheIgniteConfiguration.loadConfiguration());
	}
}
