package com.truongmai.service;

import com.truongmai.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<String, Product> products;
    static {
        products = new HashMap<>();
        products.put("S1", new Product("sua chua", "S1", 8000, "do lanh"));
        products.put("S2", new Product("sua ong tho", "S2", 24000, "do lanh"));
        products.put("S3", new Product("sua co gai ha lan", "S3", 9000, "do lanh"));
        products.put("M1", new Product("mi hao hao", "M1", 5000, "do kho"));
        products.put("M2", new Product("mi ba mien", "M2", 3000, "do kho"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public void update(String id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remote(String id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(p);
            }
        }
        return productList;
    }

}
