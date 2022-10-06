package com.malagueta.backend.credito.repository;

import com.malagueta.backend.credito.model.User;

import java.util.List;

public interface UserRepository {
    public List<User> getUsers();
    public User addUser(User user);
    public User findByName(String usrName);
}
