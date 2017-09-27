package com.example.webapigateway.userEvent;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by Mateusz on 2017-09-19.
 */
@FeignClient("user-event-service")
public interface UserEventReader {

    @RequestMapping(method = RequestMethod.GET,
            value = "/userEvents/events/{id}")
    Resources<UserEvent> read(@PathVariable(value = "id") Long id);
}
