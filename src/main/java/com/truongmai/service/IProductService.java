package com.truongmai.service;

import com.truongmai.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(String id);
    void update(String id, Product product);
    void remote(String id);
    List<Product> findByName(String name);

}
