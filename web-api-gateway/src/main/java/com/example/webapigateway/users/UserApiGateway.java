package com.example.webapigateway.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 2017-08-25.
 */
@RestController
@RequestMapping("/users")
public class UserApiGateway {

    private final UserReader userReader;
    private final UserWriter userWriter;
    private RestTemplate restTemplate;
    String serviceUrl;

    @Autowired
    public UserApiGateway(UserReader userReader, UserWriter userWriter) {
        this.userReader = userReader;
        this.userWriter = userWriter;
        restTemplate = new RestTemplate();
        serviceUrl = "http://localhost:8002/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/names")
    public Collection<String> names() {
        return this.userReader
                .read()
                .getContent()
                .stream()
                .map(User::getUserName)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ids")
    public Collection<Long> ids() {
        return this.userReader
                .read()
                .getContent()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return findUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        User user1 = findUserByName(user.getUserName(), user.getPassword());
        if (user1 != null) {
            return "Login";
        } else {
            return "Cannot find user";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public void addUser(@RequestBody User user) {
        userWriter.writeUser(user);
    }

    public User findUserByName(String name, String password) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(serviceUrl+"/{name}/{password}", User.class, name, password);
        if(responseEntity.getBody() != null)
            return responseEntity.getBody();

        return null;
    }
    public User findUserById(Long id) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(serviceUrl+"/{id}", User.class, id);
        if(responseEntity.getBody() != null)
            return responseEntity.getBody();

        return null;
    }



}
