package com.nenavizion.service;

import com.nenavizion.model.User;
import com.nenavizion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public String save(final User user) {
        return repository.save(user).getEmail();
    }

    public String update(final User user) {
        final User user1 = repository.findById(user.getEmail()).orElseThrow();
        user1.setName(user.getName());
        user1.setPass(user.getPass());
        return save(user1);
    }

    public void delete(final String email) {
        repository.deleteById(email);
    }
}