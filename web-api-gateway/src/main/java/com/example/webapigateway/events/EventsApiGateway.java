package com.example.webapigateway.events;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 2017-08-25.
 */

@RestController
@RequestMapping("/events")
public class EventsApiGateway {

    private final EventsReader eventsReader;
    private final EventWriter eventWriter;

    @Autowired
    public EventsApiGateway(EventsReader eventsReader, EventWriter eventWriter) {
        this.eventsReader = eventsReader;
        this.eventWriter = eventWriter;
    }

    public Collection<String> fallback() {
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/names")
    public Collection<String> names() {
        return this.eventsReader
                .read()
                .getContent()
                .stream()
                .map(Event::getEventName)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void editEvent(@PathVariable("id") Long id, @RequestBody Event event){
        eventsReader.edit(id,event);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void writeEvent(@RequestBody Event event) {
        eventWriter.writeEvent(event);
    }
}
