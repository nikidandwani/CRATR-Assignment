package com.assigmnet.parameterPrinterdemo.parameter.server;

import com.assigmnet.parameterPrinterdemo.configuration.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParameterSender{
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ParameterSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendParameter(Parameter parameter) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_PARAMETERS, parameter);
    }
}
