package com.nenavizion.controller;

import com.nenavizion.model.Client;
import com.nenavizion.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(final ClientService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping
    public String update(@RequestBody Client client) {
        if (client.getEmail() == null) {
            throw new IllegalArgumentException();
        }
        return service.update(client);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        service.delete(email);
    }
}
