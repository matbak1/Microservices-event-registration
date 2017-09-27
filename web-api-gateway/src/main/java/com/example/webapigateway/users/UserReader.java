package com.example.webapigateway.users;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Mateusz on 2017-08-25.
 */
@FeignClient("user-service")
public interface UserReader {

    @RequestMapping(method = RequestMethod.GET, value = "users")
    Resources<User> read();

}
