package com.assigmnet.parameterPrinterdemo;

import com.assigmnet.parameterPrinterdemo.parameter.server.ParameterSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimerDemoApplication {

	@Autowired
static 	ParameterSender sender;
	public static void main(String[] args) {
		SpringApplication.run(TimerDemoApplication.class, args);


	}
}
