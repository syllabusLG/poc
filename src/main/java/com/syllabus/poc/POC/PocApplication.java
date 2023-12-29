package com.syllabus.poc.POC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.syllabus.poc.POC.services.PocServiceImpl;

@SpringBootApplication
public class PocApplication {

	@Autowired
	private PocServiceImpl pocService;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);

	}
	@Bean
	public CommandLineRunner run(){
		pocService.extractDatas();

		return null;
	}

}

