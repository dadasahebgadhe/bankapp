package com.demo1.demo.controller;
import com.demo1.demo.service.UserService;
import com.demo1.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
//  @RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@Valid @RequestBody  User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUserById(id);

    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody  User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id){
        return userService.deleteById(id);
    }

}


