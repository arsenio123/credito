package com.malagueta.backend.credito.services;


import com.malagueta.backend.credito.model.User;

import java.util.List;

public interface UserServices {
    public List<User> getUser();
    public User getUserByName(String name);
}
