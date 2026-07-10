package com.cm.med_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "supplements")
public class Supplement{

    @Id
    private String id;

    private String name;
    private String brand;
    private String category;
    private String description;
    private double price;
    private int stock;
    private String imageUrl;
    private double rating;
    private boolean inStock;

   
}