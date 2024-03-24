package com.nenavizion.service;

import com.nenavizion.model.Jewelry;
import com.nenavizion.repository.JewelryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService {
    private final JewelryRepository repository;

    @Autowired
    public JewelryService(final JewelryRepository repository) {
        this.repository = repository;
    }

    public String save(final Jewelry jewelry) {
        return repository.save(jewelry).getId();
    }

    public String update(final Jewelry jewelry) {
        final Jewelry jewelry1 = repository.findById(jewelry.getId()).orElseThrow();
        jewelry1.setName(jewelry.getName());
        jewelry1.setPrice(jewelry.getPrice());
        jewelry1.setType(jewelry.getType());
        jewelry1.setColor(jewelry.getColor());

        return save(jewelry1);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public List<Jewelry> findAll() {
        return repository.findAll();
    }

    public Jewelry findById(final String id) {
        return repository.findById(id).orElseThrow();
    }

    public Iterable<Jewelry> findByNameContainingIgnoreCase(final String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Iterable<Jewelry> findByPrice(final int min, final int max) {
        return repository.findByPriceBetween(min, max);
    }

    public Iterable<Jewelry> findByColor(final String color) {
        return repository.findByColorIgnoreCase(color);
    }

    public Iterable<Jewelry> findByType(final String type) {
        return repository.findByType(type);
    }

    public Page<Jewelry> findPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
