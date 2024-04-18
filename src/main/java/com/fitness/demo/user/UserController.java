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
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestParam Map<String, String> params) { // binds the JSON in the request body to a muscle object
        log.info("create user: " + params);
        User user = new User(params.get("userName"), params.get("password"), params.get("bio"));
        userService.createUser(user);
        return new ResponseEntity<>("created user" + user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("all users!");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<User> authenticateAndGetUserByUserName(@RequestParam Map<String, String> params) {
        String userName = params.get("userName");
        String password = params.get("password");
        User user = userService.authenticate(userName, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
