package com.syllabus.poc.POC;

import com.syllabus.poc.POC.services.PocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PocApplication {

	@Autowired
	private PocService pocService;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);

	}
	@Bean
	public CommandLineRunner run(){
		pocService.getData("D-GT5Z-5KXXK-11");

		return null;
	}

}

