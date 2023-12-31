package com.milk;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DairyMilkApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new modelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(DairyMilkApplication.class, args);
	}

}
