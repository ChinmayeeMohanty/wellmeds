package com.cm.med_app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cm.med_app.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

    List<Product> findByProductType(String productType);

    List<Product> findByNameContainingIgnoreCase(String keyword);
    
   // List<Product> findBySymptomsContainingIgnoreCase(String symptoms);

}