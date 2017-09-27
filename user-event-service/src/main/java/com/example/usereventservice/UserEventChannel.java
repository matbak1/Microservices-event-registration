package com.example.usereventservice;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Mateusz on 2017-09-19.
 */
public interface UserEventChannel {

    String INPUT = "input";
    @Input(UserEventChannel.INPUT)
    SubscribableChannel input();
}
