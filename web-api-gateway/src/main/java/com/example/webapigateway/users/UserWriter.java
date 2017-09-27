package com.example.webapigateway.users;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by Mateusz on 2017-08-30.
 */
@MessagingGateway(defaultRequestChannel = "userOutput")
public interface UserWriter {

    @Gateway(requestChannel = "userOutput")
    void writeUser(User user);
}
