package de.bsi.userapi.service;

import de.bsi.userapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final List<User> users = new ArrayList<>();
    
    
    @Override
    public void addUser(User user) {
        users.add(user);
    }
    
    @Override
    public Optional<User> findUserBy(int userId) {
        return users.stream().filter(u -> userId == u.getId()).findFirst();
    }
}
