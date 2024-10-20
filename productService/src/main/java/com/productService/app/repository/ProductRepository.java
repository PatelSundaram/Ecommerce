package com.productService.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productService.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
