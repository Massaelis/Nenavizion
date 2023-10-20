package com.nenavizion.controller;

import com.nenavizion.model.Jewelry;
import com.nenavizion.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {
    private final JewelryService service;

    @Autowired
    public JewelryController(final JewelryService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Jewelry jewelry) {
        if (jewelry.getName() == null) {
            jewelry.setName("Default name");
            jewelry.setPrice(000);
            jewelry.setType("Default type");
            jewelry.setColor("Default color");
        }
        return service.save(jewelry);
    }

    @PutMapping
    public String updateGreeter(@RequestBody Jewelry jewelry) {
        if (jewelry.getId() == null) {
            throw new IllegalArgumentException();
        }
        return service.update(jewelry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping
    public Iterable<Jewelry> findAll() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public Jewelry findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/{name}")
    public Jewelry findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/{price}")
    public Jewelry findByPrice(@PathVariable int price) {
        return service.findByPrice(price);
    }

    @GetMapping("/{type}")
    public Jewelry findByType(@PathVariable String type) {
        return service.findByType(type);
    }

    @GetMapping("/{color}")
    public Jewelry findByColor(@PathVariable String color) {
        return service.findByColor(color);
    }
}