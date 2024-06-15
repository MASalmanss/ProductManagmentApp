package com.MaSalman.productmanagement.exeption;

public class ProductNotFoundExeption extends RuntimeException{
    public ProductNotFoundExeption(String massage){
        super(massage);
    }
}
