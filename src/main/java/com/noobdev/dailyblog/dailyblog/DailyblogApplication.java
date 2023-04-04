package com.noobdev.dailyblog.dailyblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DailyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyblogApplication.class, args);

	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}

