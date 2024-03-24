package com.nenavizion.repository;

import com.nenavizion.model.Jewelry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, String> {
    Iterable<Jewelry> findByNameContainingIgnoreCase(String name);

    Iterable<Jewelry> findByPriceBetween(int min, int max);

    Iterable<Jewelry> findByColorIgnoreCase(String color);

    Iterable<Jewelry> findByType(String type);

    long count();
}