package com.example.eventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mateusz on 2017-09-23.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void editEvent(@PathVariable("id") Long id, @RequestBody Event event){
        Event event1 = eventRepository.findOne(id);
        event1.setEventName(event.getEventName());
        event1.setCategory(event.getCategory());
        event1.setLocalization(event.getLocalization());
        event1.setCost(event.getCost());
        event1.setMaxMemberCount(event.getMaxMemberCount());
        event1.setDescription(event.getDescription());
        eventRepository.save(event1);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteEvent(@PathVariable("id") Long id){
        eventRepository.delete(id);
    }
}
