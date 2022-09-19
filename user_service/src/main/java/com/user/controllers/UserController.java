package com.user.controllers;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){

        User user =  userService.getUser(userId);

        List<Contact> contactList =  restTemplate.getForObject("http://Contact-Service/contact/user/"+ userId, List.class);

        user.setContacts(contactList);

        return  user;

    }
}
