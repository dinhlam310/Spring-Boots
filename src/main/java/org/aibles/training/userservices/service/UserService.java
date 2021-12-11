package org.aibles.training.userservices.service;

import org.aibles.training.userservices.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUser();

    User getUser(int id);

    void deleteUser(int id);

    User createUser (User user);

    User updateUser(int id,User user);

}
