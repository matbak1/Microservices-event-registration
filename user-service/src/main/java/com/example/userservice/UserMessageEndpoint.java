package com.example.userservice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Mateusz on 2017-09-19.
 */
@EnableBinding(UserChannel.class)

@MessageEndpoint
public class UserMessageEndpoint {

    private final UserRepository userRepository;

    @Autowired
    public UserMessageEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ServiceActivator(inputChannel = UserChannel.INPUT1)
    public void onMessage(String user) {
        JSONParser jsonParser = new JSONParser();
        Object object = null;
        JSONObject jsonObject = null;

        try {
            object = jsonParser.parse(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) object;

        this.userRepository.save(new User(
                jsonObject.get("userName").toString(),
                jsonObject.get("password").toString(),
                Integer.parseInt(jsonObject.get("userId").toString())
        ));
    }



}
