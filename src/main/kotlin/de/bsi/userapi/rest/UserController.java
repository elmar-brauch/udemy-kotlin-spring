package de.bsi.userapi.rest;

import de.bsi.userapi.model.User;
import de.bsi.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired private UserService service;
    
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        service.addUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam int id) {
        var optUser = service.findUserBy(id);
        return ResponseEntity.of(optUser);
    }
    
}
