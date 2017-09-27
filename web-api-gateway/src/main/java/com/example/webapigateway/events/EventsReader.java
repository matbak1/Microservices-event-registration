package com.example.webapigateway.events;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mateusz on 2017-08-25.
 */
@FeignClient("event-service")
public interface EventsReader {

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    Resources<Event> read();

    @RequestMapping(method = RequestMethod.PUT, value = "/events/{id}")
    Resources<Event> edit(@PathVariable("id") Long id, @RequestBody Event event);
}
