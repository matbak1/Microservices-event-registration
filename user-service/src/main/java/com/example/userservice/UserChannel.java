package com.example.userservice;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Mateusz on 2017-09-19.
 */
public interface UserChannel {

    String INPUT1 = "input1";

    @Input(UserChannel.INPUT1)
    SubscribableChannel input1();

}
