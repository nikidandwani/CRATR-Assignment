package com.assigmnet.parameterPrinterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PrinterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrinterDemoApplication.class, args);


	}
}
