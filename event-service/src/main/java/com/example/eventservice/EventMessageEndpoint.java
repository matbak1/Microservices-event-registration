package com.example.eventservice;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Mateusz on 2017-08-25.
 */
@EnableBinding(EventChannel.class)
@MessageEndpoint
public class EventMessageEndpoint {

    private final EventRepository eventRepository;

    @Autowired
    public EventMessageEndpoint(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @ServiceActivator(inputChannel = EventChannel.INPUT)
    public void onMessage(String event){
        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        Object object = null;
        JSONObject jsonObject = null;
        try {
            object = jsonParser.parse(event);
             jsonObject = (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.eventRepository.save(new Event(
                jsonObject.get("eventName").toString(),
                jsonObject.get("category").toString(),
                jsonObject.get("localization").toString(),
                Double.parseDouble(jsonObject.get("cost").toString()),
                Integer.parseInt(jsonObject.get("maxMemberCount").toString()),
                jsonObject.get("description").toString()
        ));
    }

}
