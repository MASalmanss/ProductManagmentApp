package com.MaSalman.productmanagement.repository;

import com.MaSalman.productmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product , Integer> {
}
