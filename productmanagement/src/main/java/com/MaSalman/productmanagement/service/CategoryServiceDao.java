package com.MaSalman.productmanagement.service;

import com.MaSalman.productmanagement.entity.Category;

import java.util.List;

public interface CategoryServiceDao {

    public List<Category> findAll();

    public Category findBtId(int id);

    public Category save(Category category);

    public void deleteById(int id);
}
