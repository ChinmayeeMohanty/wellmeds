package com.cm.med_app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cm.med_app.model.Medicine;

public interface MedicineRepo extends MongoRepository<Medicine,String> {

	List<Medicine> findBySymptomsContainingIgnoreCase(String symptoms);
	List<Medicine> findByNameContainingIgnoreCase(String keyword);
	
}
