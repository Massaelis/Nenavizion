package com.nenavizion.service;

import com.nenavizion.model.Client;
import com.nenavizion.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(final ClientRepository repository) {
        this.repository = repository;
    }

    public String save(final Client client) {
        return repository.save(client).getEmail();
    }

    public String update(final Client client) {
        final Client client1 = repository.findById(client.getEmail()).orElseThrow();
        client1.setName(client.getName());
        client1.setPass(client.getPass());
        return save(client1);
    }

    public void delete(final String email) {
        repository.deleteById(email);
    }
}