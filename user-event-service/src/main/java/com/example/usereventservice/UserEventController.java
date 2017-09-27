package com.example.usereventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mateusz on 2017-09-19.
 */

@RestController
@RequestMapping("/userEvents")
public class UserEventController {

    private final UserEventRepository userEventRepository;


    @Autowired
    public UserEventController(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/events/{id}")
    public List<UserEvent> getEventUser(@PathVariable("id") Long id) {
        return userEventRepository.findByUserId(id);
    }
}

