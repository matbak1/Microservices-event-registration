package com.example.webapigateway.events;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by Mateusz on 2017-08-25.
 */
@MessagingGateway(defaultRequestChannel = "eventOutput")
interface EventWriter {

    @Gateway(requestChannel = "eventOutput")
    void writeEvent(Event event);
}
