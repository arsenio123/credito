package com.malagueta.backend.credito.services.impl;


import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.UserRepository;
import com.malagueta.backend.credito.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServicesImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public List<User> getUser(){
        return userRepository.getUsers();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
