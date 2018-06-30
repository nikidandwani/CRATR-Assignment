package com.assigmnet.parameterPrinterdemo.printer.server;


import com.assigmnet.parameterPrinterdemo.parameter.server.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The printer
 *
 * The aim of this component is to print (say to a log file) the parameter p (as indicated by the parameter)
 * and the time left until the end of this year.  It should print whenever p changes and also if 0.01 virtual days
 * has passed since the last print.
 */

@Component
public class ParameterPrinter {
    static final Logger logger = LoggerFactory.getLogger(ParameterPrinter.class);

    Parameter printerParameter=new Parameter(0);

    @RabbitListener(queues = "parameters-queue") //receiving changed value of p from parameter server
    public void processOrder(Parameter parameter) {
        logger.info("Message recieved on Queue : parameters-queue");
        printerParameter.setP(parameter.getP());
       printParameter(); //logging paramter value when p from paramter server is changed
    }
@Scheduled(fixedRate = 20736000) //logging parameter value every 0.01 virtual days i.e 0.24hours = 20736000 mili seconds
    public void printParameter(){
        logger.info("Parameter Value: "+printerParameter.getP());
        logger.info();
    }
}
