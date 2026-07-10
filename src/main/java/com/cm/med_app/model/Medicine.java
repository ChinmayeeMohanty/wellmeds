package com.cm.med_app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="medics")
public class Medicine {
   private String id;
   private String name;
   private Double price;
   private String manufacture;
   private String imageUrl;
   private List<String> symptoms;

}
