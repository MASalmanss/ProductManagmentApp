package com.MaSalman.productmanagement.service;

import com.MaSalman.productmanagement.entity.Category;
import com.MaSalman.productmanagement.entity.Product;

import java.util.List;

public interface ProductServiceDao {

    List<Product> findAll();

    Product findById(int theId);

    void save(Product product);

    void delete(int id);


}
