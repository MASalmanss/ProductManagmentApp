package com.MaSalman.productmanagement.rest;

import com.MaSalman.productmanagement.entity.Product;
import com.MaSalman.productmanagement.service.ProductServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    private final ProductServiceDao productServiceDao;

    @Autowired
    public ProductRestController(ProductServiceDao productServiceDao) {
        this.productServiceDao = productServiceDao;
    }

    @GetMapping("/product")
    public List<Product> getAll() {
        return productServiceDao.findAll();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        product.setId(0);
        productServiceDao.save(product);
        return product;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        productServiceDao.save(product);
        return product;
    }

    @DeleteMapping("/product/{product_id}")
    public String deleteProduct(@PathVariable int product_id) {
        Product product = productServiceDao.findById(product_id);
        if (product == null) {
            throw new RuntimeException("Product not found with id - " + product_id);
        }
        productServiceDao.delete(product_id);
        return "Deleted product id - " + product_id;
    }
}
