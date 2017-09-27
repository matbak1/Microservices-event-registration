package com.example.webapigateway.userEvent;

import com.example.webapigateway.users.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 2017-09-19.
 */

@RestController
@RequestMapping("/userEvent")
public class UserEventApiGateway {

    private final UserEventReader userEventReader;
    private final UserEventWriter userEventWriter;


    @Autowired
    public UserEventApiGateway(UserEventReader userEventReader, UserEventWriter userEventWriter) {
        this.userEventReader = userEventReader;
        this.userEventWriter = userEventWriter;
    }

    public Collection<Long> fallback(Long id){
        return new ArrayList<>();
    }

//    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/events/{id}")
    public Collection<Long> userEventIds(@PathVariable ("id") Long id){
        return this.userEventReader
                .read(id)
                .getContent()
                .stream()
                .map(UserEvent::getUserId)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void writeUserEvent(@RequestBody UserEvent userEvent){
        userEventWriter.writeUserEvent(userEvent);
    }
}
