package com.anhdai.app.web;

import com.anhdai.model.UserEntity;
import com.anhdai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Value("${username123:Null}")
    private String name;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello(){
        return "Hello" + name;
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody UserEntity user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable long id){
        Map<String, Boolean> response = new HashMap<>();
        userService.deleteUser(id);
        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
