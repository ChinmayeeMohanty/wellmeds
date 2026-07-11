//package com.cm.med_app.service;
//
//
//import com.cm.med_app.model.Medicine;
//import com.cm.med_app.repository.MedicineRepo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class MedicineService {
//
//   @Autowired
//   private MedicineRepo medRepository;
//
//  
//    public List<Medicine> getAll() {
//        return medRepository.findAll();
//    }
//
//    public Medicine add(Medicine med) {
//       
//        return medRepository.save(med);
//    }
//
//    public Medicine getById(String id) {
//        return medRepository.findById(id).orElse(null);
//    }
//
//    public String delete(String id) {
//    	medRepository.deleteById(id);
//        return "Deleted";
//    }
//     public Medicine update(String id,Medicine medicine)
//     {
//    	 Medicine existing=medRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
//    	 existing.setName(medicine.getName());
//    	 existing.setPrice(medicine.getPrice());
//    	 existing.setManufacture(medicine.getManufacture());
//    	 existing.setImageUrl(medicine.getImageUrl());
//    	  
//    	 
//    	 return medRepository.save(existing);
//     }
//     public Medicine patchUpdate(String id,Map<String,Object> updates)
//     {
//    	 Medicine existing=medRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
//    	 updates.forEach((key,value)->{
//    	
//    		 switch(key)
//    		 {
//    		 case "name":existing.setName((String)value);
//    		 break;
//    		 case "Price":existing.setPrice(Double.valueOf(value.toString()));
//    		 break;
//    		 case "Manufacture":existing.setManufacture((String)value);
//    		 break;
//    		 case "imageUrl":existing.setImageUrl((String)value);   			
//    		 }
//    	 });
//    	 return medRepository.save(existing);
//    	 
//     }
//     
//     public List<Medicine> search(String keyword)
//     {
//    	 return medRepository.findByNameContainingIgnoreCase(keyword);
//     }
//}