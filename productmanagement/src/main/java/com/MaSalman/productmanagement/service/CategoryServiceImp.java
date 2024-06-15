package com.MaSalman.productmanagement.service;

import com.MaSalman.productmanagement.entity.Category;
import com.MaSalman.productmanagement.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryServiceDao{


    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImp(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findBtId(int id) {
        Optional<Category> tempCategory = categoryDao.findById(id);
        Category category = null;
        if(tempCategory.isPresent()){
            category = tempCategory.get();
        }
        else {
            throw new RuntimeException("Category not found");
        }
        return category;
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryDao.deleteById(id);
    }
}
