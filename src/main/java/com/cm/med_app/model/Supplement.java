package com.cm.med_app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Supplement extends Product {

    private String brand;
    private String category;
    private int stock;
    private double rating;
    private boolean inStock;
}