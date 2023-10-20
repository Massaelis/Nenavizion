package com.nenavizion.controller;

import com.nenavizion.model.User;
import com.nenavizion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(final UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping
    public String update(@RequestBody User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException();
        }
        return service.update(user);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        service.delete(email);
    }
}
