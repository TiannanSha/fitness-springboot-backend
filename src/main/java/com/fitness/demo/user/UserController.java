package com.fitness.demo.user;

import com.fitness.demo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> body) { // binds the JSON in the request body to a muscle object
//        log.info("create user: " + params);
//        String username = params.get("username");
//        String password = params.get("password");
//        User user = new User(username, password, params.get("bio"));
        String username = body.get("username");
        String password = body.get("password");
        User user = new User(username, password, "bio");
        if (username!=null && password!=null) {
            userService.createUser(user);
            return new ResponseEntity<>("created user " + user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("registration failed, either username or password is null", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("all users!");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<User> authenticateAndGetUserByUserName(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        User user = userService.authenticate(username, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
