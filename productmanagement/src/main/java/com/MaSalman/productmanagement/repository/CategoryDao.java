package com.MaSalman.productmanagement.repository;

import com.MaSalman.productmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category , Integer> {
}
