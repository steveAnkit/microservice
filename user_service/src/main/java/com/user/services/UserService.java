package com.user.services;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    //dummy user list

    List<User> userList= List.of(
            new User(1L , "Tom", "12321333"),
            new User(2L , "Dick", "99999999")
    );

    @Override
    public User getUser(Long id) {
        return userList.stream().filter(user -> user.getUserID().equals(id)).findAny().orElse(null);
    }
}
