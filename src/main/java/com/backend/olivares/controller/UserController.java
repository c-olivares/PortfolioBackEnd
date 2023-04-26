package com.backend.olivares.controller;

import com.backend.olivares.model.User;
import com.backend.olivares.repo.UserRepo;
import com.backend.olivares.status.Status;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="https://portfolio-carlos-olivares.web.app")
public class UserController {

    @Autowired
    private UserRepo repo;

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    
 @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = repo.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                repo.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }
   
    }
