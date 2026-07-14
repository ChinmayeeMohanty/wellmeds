package com.cm.med_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "doctors")
public class Doctor {

    @Id
    private String id;

    private String name;

    private String specialization;

    private int experience;   // in years

    private String qualification;


    private String email;

    private String phone;


    private double consultationFee;


    private boolean available;
}