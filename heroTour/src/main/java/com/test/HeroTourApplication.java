package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HeroTourApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HeroTourApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowCredentials(false)//就是这个啦
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "DELETE", "PUT");
	}

}
