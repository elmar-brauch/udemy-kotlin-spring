package de.bsi.userapi.service;

import de.bsi.userapi.model.User;

import java.util.Optional;

public interface UserService {
    
    /**
     * Adds given user to stored list of users.
     */
    void addUser(User user);
    
    /**
     * Searches for user with given id and returns it.
     */
    Optional<User> findUserBy(int userId);
    
}
