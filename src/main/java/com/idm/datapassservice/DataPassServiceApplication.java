package com.idm.datapassservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({
	"com.idm.controller",
	"com.idm.exceptionhandler",
	"com.idm.service",
	"com.idm.scheduling"
})
@EnableJpaRepositories("com.idm.dao")
@EntityScan("com.idm.model")
@EnableScheduling
@SpringBootApplication
public class DataPassServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPassServiceApplication.class, args);
	}
	
}
