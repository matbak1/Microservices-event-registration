package com.example.webapigateway;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Mateusz on 2017-09-19.
 */
public interface MessageChannels {

    String OUTPUT1 = "eventOutput";
    String OUTPUT2 = "userOutput";
    String OUTPUT3 = "userEventOutput";

    @Output(MessageChannels.OUTPUT1)
    MessageChannel eventOutput();

    @Output(MessageChannels.OUTPUT2)
    MessageChannel userOutput();

    @Output(MessageChannels.OUTPUT3)
    MessageChannel userEventOutput();

}

