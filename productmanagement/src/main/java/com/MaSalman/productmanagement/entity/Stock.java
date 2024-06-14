package com.MaSalman.productmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stock")
    private int stock;

    // Default constructor
    public Stock() {
    }

    // Constructor with parameters
    public Stock(int stock) {
        this.stock = stock;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stock=" + stock +
                '}';
    }
}
