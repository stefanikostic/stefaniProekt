package com.example.stefaniProekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StefaniProektApplication {

	public static void main(String[] args) {
		SpringApplication.run(StefaniProektApplication.class, args);
	}

}
