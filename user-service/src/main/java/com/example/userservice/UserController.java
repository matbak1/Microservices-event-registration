package com.example.userservice;

import org.bouncycastle.crypto.tls.UDPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mateusz on 2017-09-19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}/{password}")
    public User findUser(@PathVariable ("name") String  name,
                         @PathVariable ("password") String  passord){
        User user  = userRepository.findByuserName(name);
        if (user.getPassword().equals(passord))
            return user;
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User findById(@PathVariable("id") Long id){
        return userRepository.findOne(id);
    }

}
