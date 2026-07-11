//package com.cm.med_app.service;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.cm.med_app.model.Supplement;
//import com.cm.med_app.repository.SupplementRepository;
//
//@Service
//public class SupplementService {
//
//	 @Autowired
//	   private SupplementRepository suppRepository;
//
//	  
//	    public List<Supplement> getAll() {
//	        return suppRepository.findAll();
//	    }
//
//	    public Supplement add(Supplement supp) {
//	       
//	        return suppRepository.save(supp);
//	    }
//
//	    public Supplement getById(String id) {
//	        return suppRepository.findById(id).orElse(null);
//	    }
//
//	    public String delete(String id) {
//	    	suppRepository.deleteById(id);
//	        return "Deleted";
//	    }
//	    
//}
