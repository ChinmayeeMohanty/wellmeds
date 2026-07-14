package com.cm.med_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cm.med_app.model.Appointment;
import com.cm.med_app.model.Doctor;
import com.cm.med_app.model.Product;
import com.cm.med_app.service.AdminService;





@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired	
    private AdminService adminService;


    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(adminService.getAll());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        Product saved = adminService.add(product);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable String id,
            @RequestBody Product product) {

        Product updated = adminService.updateProduct(id, product);

        return ResponseEntity.ok(updated);
    }


    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {

        adminService.delete(id);

        return ResponseEntity.ok("Product deleted successfully.");
    }

   
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {

        Doctor saved = adminService.addDoctor(doctor);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }



  
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments() {

        return ResponseEntity.ok(adminService.getAppointments());
    }

}
