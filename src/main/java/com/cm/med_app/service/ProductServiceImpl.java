package com.cm.med_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Product;
import com.cm.med_app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Product> getMedicines() {
        return repo.findByProductType("MEDICINE");
    }

    @Override
    public List<Product> getSupplements() {
        return repo.findByProductType("SUPPLEMENT");
    }

    @Override
    public Product getById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Product add(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}