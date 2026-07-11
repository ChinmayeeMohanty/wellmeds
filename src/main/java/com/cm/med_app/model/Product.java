package com.cm.med_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="products")
public class Product {

	   @Id
	    private String id;

	    private String name;
	    private String description;
	    private double price;
	    private String imageUrl;

	    // MEDICINE or SUPPLEMENT
	    private String productType;
}
