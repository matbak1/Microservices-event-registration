package com.example.usereventservice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Mateusz on 2017-09-19.
 */
@org.springframework.integration.annotation.MessageEndpoint
public class MessageEndpoint {

    private final UserEventRepository userEventRepository;

    @Autowired
    public MessageEndpoint(UserEventRepository userEventRepository) {
        this.userEventRepository = userEventRepository;
    }

    @ServiceActivator(inputChannel = UserEventChannel.INPUT)
    public void onMessage(String userEvent) {
        JSONParser jsonParser = new JSONParser();
        Object object = null;
        JSONObject jsonObject = null;
        try {
            object = jsonParser.parse(userEvent);
            jsonObject = (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.userEventRepository.save(new UserEvent(
                Integer.parseInt(jsonObject.get("userId").toString()),
                Integer.parseInt(jsonObject.get("eventId").toString())

        ));

    }

}
