package com.cm.med_app.service;

import java.util.List;

import com.cm.med_app.model.Product;

public interface ProductService {

    List<Product> getAll();

    List<Product> getMedicines();

    List<Product> getSupplements();

    Product getById(String id);

    Product add(Product product);

  //  Product update(String id, Product product);

    List<Product> search(String keyword);
}