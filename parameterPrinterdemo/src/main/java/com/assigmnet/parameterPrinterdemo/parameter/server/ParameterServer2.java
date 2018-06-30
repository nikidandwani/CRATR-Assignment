package com.assigmnet.parameterPrinterdemo.parameter.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * a Simple server which will do the task only once at start up
 */
@Component
public class ParameterServer2 implements CommandLineRunner {
    @Autowired ParameterSender sender;

    @Override public void run(String... args) throws Exception {
        Parameter param = new Parameter();
        param.setP(123);
        sender.sendParameter(param);

    }
}
