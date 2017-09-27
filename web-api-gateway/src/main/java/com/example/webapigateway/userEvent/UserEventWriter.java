package com.example.webapigateway.userEvent;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by Mateusz on 2017-09-19.
 */

@MessagingGateway(defaultRequestChannel = "userEventOutput")
public interface UserEventWriter {

    @Gateway(requestChannel = "userEventOutput")
    void writeUserEvent(UserEvent userEvent);

}
