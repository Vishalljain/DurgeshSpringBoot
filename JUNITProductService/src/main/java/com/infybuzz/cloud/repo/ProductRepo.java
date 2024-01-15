package com.infybuzz.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infybuzz.cloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
