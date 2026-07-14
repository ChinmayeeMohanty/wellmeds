package com.cm.med_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cm.med_app.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor,String>{

}
