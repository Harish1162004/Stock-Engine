package com.stockengine.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")   // ✅ FIX: avoid MySQL reserved keyword "order"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String stock;
    private String type; // BUY or SELL
    private int quantity;
    private double price;

    // ✅ No-arg constructor (required by JPA)
    public Order() {
    }

    // ✅ Parameterized constructor
    public Order(String username, String stock, String type, int quantity, double price) {
        this.username = username;
        this.stock = stock;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    // =====================
    // ✅ GETTERS
    // =====================

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStock() {
        return stock;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // =====================
    // ✅ SETTERS
    // =====================

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
