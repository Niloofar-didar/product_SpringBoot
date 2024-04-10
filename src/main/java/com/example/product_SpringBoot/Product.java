package com.example.product_SpringBoot;

public class Product {
    private String code;
    private String item;
    private double price;
    private double discount;
    private int available;

    // Constructors, getters, and setters

    public Product() {
    }

    public Product(String code, String item, double price, double discount, int available) {
        this.code = code;
        this.item = item;
        this.price = price;
        this.discount = discount;
        this.available = available;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}

