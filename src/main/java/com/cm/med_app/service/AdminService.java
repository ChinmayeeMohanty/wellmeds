package com.cm.med_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Appointment;
import com.cm.med_app.model.Doctor;
import com.cm.med_app.model.Medicine;
import com.cm.med_app.model.Product;
import com.cm.med_app.model.Supplement;
import com.cm.med_app.repository.AppointmentRepository;
import com.cm.med_app.repository.DoctorRepository;
import com.cm.med_app.repository.ProductRepository;


@Service
public class AdminService {

	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private  DoctorRepository doctorRepository;
	
	@Autowired
    private  AppointmentRepository appointmentRepository;
	
	
	
	public List<Product> getAll() {
	    return productRepository.findAll();
	}

    public Product add(Product product) 
	{
    	return productRepository.save(product); 
    }

    
    public Product updateProduct(String id, Product product) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Common fields
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setImageUrl(product.getImageUrl());
        existing.setProductType(product.getProductType());

        // Medicine-specific fields
        if (existing instanceof Medicine existingMedicine &&
            product instanceof Medicine medicine) {

            existingMedicine.setManufacture(medicine.getManufacture());
            existingMedicine.setSymptoms(medicine.getSymptoms());
        }

        // Supplement-specific fields
        if (existing instanceof Supplement existingSupplement &&
            product instanceof Supplement supplement) {

            existingSupplement.setBrand(supplement.getBrand());
            existingSupplement.setCategory(supplement.getCategory());
            existingSupplement.setStock(supplement.getStock());
            existingSupplement.setRating(supplement.getRating());
            existingSupplement.setInStock(supplement.getInStock());
        }

        return productRepository.save(existing);
    }
    
    public void delete(String id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    public List<Appointment> getAppointments() {

        return appointmentRepository.findAll();
    }

}
