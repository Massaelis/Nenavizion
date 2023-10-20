package com.nenavizion.repository;

import com.nenavizion.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, String> {
    Optional<Jewelry> findByName(String name);

    Optional<Jewelry> findByPrice(int price);

    Optional<Jewelry> findByColor(String color);

    Optional<Jewelry> findByType(String type);
}