package com.truongmai.model;

public class Product {
    private String name;
    private String id;
    private double price;
    private String title;

    public Product() {
    }

    public Product(String name, String id, double price, String title) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
