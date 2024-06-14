package com.MaSalman.productmanagement.service;

import com.MaSalman.productmanagement.entity.Product;
import com.MaSalman.productmanagement.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductServiceDao {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(int theId) {
       Optional<Product> result = productDao.findById(theId);
       Product product = null;


       if(result.isPresent()) product = result.get();
       else throw new RuntimeException("Product did not found " + theId );

       return product;
    }

    @Override
    public void save(Product product) {

        productDao.save(product);

    }

    @Override
    public void delete(int id) {
        productDao.deleteById(id);

    }
}
