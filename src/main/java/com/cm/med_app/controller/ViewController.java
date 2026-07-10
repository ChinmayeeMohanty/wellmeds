package com.cm.med_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cm.med_app.model.Appointment;
import com.cm.med_app.model.Medicine;
import com.cm.med_app.service.AppointmentService;
import com.cm.med_app.service.MedicineAIService;
import com.cm.med_app.service.MedicineService;

@Controller
public class ViewController {
	 @Autowired
	    private MedicineService service;
	 @Autowired
	 private MedicineAIService medicineAIService;
	 @Autowired
	 private AppointmentService appointmentService;

	    @GetMapping("/")
	    public String home(Model model) {
	    	List<Medicine> products=service.getAll();
	    	model.addAttribute("products",products);
	    	System.out.println(service.getAll());
	        return "home";
	    }

	    @PostMapping("/recommend")
	    public String recommend(@RequestParam String query,Model model) {
	    	String response= medicineAIService.recommendMedicine(query);
	    	model.addAttribute("response",response);
	        return "home";
	    }
    
	    @PostMapping("/add")
	    public String addMedicine(Medicine medicine)
	    {
	    	service.add(medicine);
	    	return "redirect:/";
	    }
	    
	    @GetMapping("/add")
	    public String showAddPage()
	    {
	    	return "add-medicine";
	    }
	    
	    @GetMapping("/edit/{id}")
	    public String showEditPage(@PathVariable String id,Model model)
	    {
	    	Medicine medicine=service.getById(id);
	    	if(medicine == null) {
	            return "redirect:/";
	        }
	    	model.addAttribute("medicine",medicine);
	    	return "edit-medicine";
	    }
	    
	    @PostMapping("/edit/{id}")
	    public String editMedicine(@PathVariable String id,
	    		Medicine medicine)
	    {
	    	service.update( id,medicine);
	    	return "redirect:/";
	    }
//	    @GetMapping("/{id}")
//	    public Medicine getById(@PathVariable String id) {
//	        return service.getById(id);
//	    }
//
//	    @DeleteMapping("/{id}")
//	    public String delete(@PathVariable String id) {
//	        return service.delete(id);
//	    }
	    
	   @GetMapping("/appointment")
	   public String appointmentForm(Model model)
	   {
		   model.addAttribute("appointment",new Appointment());
		   return "appointment-form";
	   }
	   
	   @PostMapping("/appointment")
	   public String saveAppointment(@ModelAttribute Appointment appointment,Model model)
	   {
		   Appointment newAppointment = appointmentService.saveAppointment(appointment);
		   appointmentService.sendAppointmentEmail(newAppointment);
		   model.addAttribute("ticket", newAppointment);
		   return "ticket";
	   }
	   @GetMapping("/search")
	   public String search(@RequestParam String keyword, Model model) {

	       model.addAttribute("products", service.search(keyword));
	       model.addAttribute("keyword", keyword);

	       return "home";
       }
	   
	   
}
