package com.organitiempo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.models.persona.*", "com.services.persona.*", "com.repository.persona.*" })
public class RestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
