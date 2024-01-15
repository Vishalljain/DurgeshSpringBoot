package com.bharath.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
