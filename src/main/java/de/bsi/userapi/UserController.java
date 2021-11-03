package de.bsi.userapi;

import de.bsi.itemapi.model.Item;
import de.bsi.itemapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired private ItemService itemService;
    
    private List<User> users = new ArrayList<>();
    
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        users.add(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("/{userId}/item")
    public ResponseEntity<User> addItemsToUser(
            @PathVariable int userId,
            @RequestBody List<String> itemIds) {
        var optionalUser = users.stream().filter(u -> userId == u.getId()).findFirst();
        if (optionalUser.isPresent()) {
            optionalUser.get().getOwnedItems().addAll(findItems(itemIds));
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    private List<Item> findItems(List<String> itemIds) {
        var result = new ArrayList<Item>();
        for (String id : itemIds)
            result.add(itemService.findItemById(id));
        return result;
    }
    
    @GetMapping
    public ResponseEntity<List<User>> readAllUsers() {
        return ResponseEntity.ok(users);
    }
    
}
