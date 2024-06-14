package com.MaSalman.productmanagement;

import com.MaSalman.productmanagement.entity.Product;
import com.MaSalman.productmanagement.service.ProductServiceDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmanagementApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ProductServiceDao productServiceDao){
		return  result -> {
			List<Product> myList = productServiceDao.findAll();
			System.out.println(myList.toString());
		};
	}

}
