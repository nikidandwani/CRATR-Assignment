package com.assigmnet.parameterPrinterdemo.parameter.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Server that will calculate p and send message every time the value of p is updated.
 * this server will perform this activity recursively with a dely of 1 second between each action
 * Step1: Set p = 0.
 * Step2: Generate a random number r between 0 and 0.02.  Sleep for r days.
 * Step3: Generate a random number s between 0 and 1.  Set p = p + s.
 * Step4: Publish/broadcast p to all interested parties.
 * Step5: Go back to Step2.
 */
@Component
public class ParameterServer {

    @Autowired ParameterSender sender;
    static final Logger logger = LoggerFactory.getLogger(ParameterServer.class);
    Parameter parameter =  new Parameter(0);

    @Scheduled(fixedDelay = 1000) //implementing step 5
    public void generateParameter(){

        double rDays = (Math.random()*((0-0.02)+1))+0;
        double rHours=rDays * 24;
        int rMiliSeconds= (int) Math.round(rHours*60*1000);
        try {
            logger.info("Thread going to sleep for r days: "+rDays);
            Thread.sleep(rMiliSeconds);
        } catch (InterruptedException e) {
            logger.info("Thread interrupted from sleep");
        }
        logger.info("Thread finished sleep");
        double s = (Math.random()*((0-1)+1))+0;

        this.parameter.setP(this.parameter.getP()+s);
        sender.sendParameter(this.parameter); //sending p to all parties listening to the queue
    }
}
