package com.stockengine.backend.dto;

public class PortfolioItem {

    private String stock;
    private int quantity;
    private double invested;

    public PortfolioItem(String stock, int quantity, double invested) {
        this.stock = stock;
        this.quantity = quantity;
        this.invested = invested;
    }

    public String getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getInvested() {
        return invested;
    }
}
