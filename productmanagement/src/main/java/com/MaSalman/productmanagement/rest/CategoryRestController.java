package com.MaSalman.productmanagement.rest;


import com.MaSalman.productmanagement.entity.Category;
import com.MaSalman.productmanagement.service.CategoryServiceDao;
import com.MaSalman.productmanagement.service.ProductServiceDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {


    private final CategoryServiceDao categoryServiceDao;

    public CategoryRestController(CategoryServiceDao categoryServiceDao) {
        this.categoryServiceDao = categoryServiceDao;
    }

    @GetMapping("/category")
    public List<Category> getAll(){
      return  categoryServiceDao.findAll();
    }

    @GetMapping("/category/{categories_id}")
    public Category getCategory(@PathVariable int categories_id){
        return categoryServiceDao.findBtId(categories_id);
    }

    @GetMapping("/category/{category_id}/products")
    public Category getCategoryWithProduct(@PathVariable int category_id){
        Category category = categoryServiceDao.findBtId(category_id);
        if(category == null) throw new RuntimeException("Category not found");
        return category;
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){
        Category tempCategory;
      if (category == null) throw new RuntimeException("Category is null");
      else tempCategory = category;
      tempCategory.setId(0);
      categoryServiceDao.save(tempCategory);
      return tempCategory;
    }

    @PutMapping("/category")
    public Category putcategory(@RequestBody Category category){
        categoryServiceDao.save(category);
        return category;
    }

    @DeleteMapping("/category/{category_id}")
    public String deletebById( @PathVariable int category_id ){
        Category tempcategory = categoryServiceDao.findBtId(category_id);
        if(tempcategory == null) throw new RuntimeException("Category not found");
        else categoryServiceDao.deleteById(category_id);
        return "deleted";
    }
}
