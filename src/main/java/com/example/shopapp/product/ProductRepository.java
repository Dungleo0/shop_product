package com.example.shopapp.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {


    Optional<Product> findById(String s);
}
