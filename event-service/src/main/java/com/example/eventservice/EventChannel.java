package com.example.eventservice;

/**
 * Created by Mateusz on 2017-08-25.
 */
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EventChannel {

    String INPUT = "input1";
    @Input(EventChannel.INPUT)
    SubscribableChannel input1();
}
