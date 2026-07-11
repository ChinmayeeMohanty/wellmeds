//package com.cm.med_app.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cm.med_app.model.Medicine;
//import com.cm.med_app.service.MedicineService;
//
//@RestController
//@RequestMapping("/meds")
//public class MedicineController {
//    @Autowired
//    private MedicineService service;
//
//    @GetMapping
//    public List<Medicine> getAll() {
//        return service.getAll();
//    }
//
//    @PostMapping("/add")
//    public Medicine add(@RequestBody Medicine med) {
//        return service.add(med);
//    }
//
//    @GetMapping("/{id}")
//    public Medicine getById(@PathVariable String id) {
//        return service.getById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable String id) {
//        return service.delete(id);
//    }
//    
//    @PutMapping("/{id}")
//    public Medicine update(@PathVariable String id,@RequestBody Medicine med)
//    {
//    	return service.update(id, med);
//    }
//    
//     @PatchMapping("/{id}")
//     public Medicine patchUpdate(@PathVariable String id,@RequestBody Map<String,Object> updates )
//     {
//    	 return service.patchUpdate(id,updates);
//     }
//    
//     @GetMapping("/search/{keyword}")
//     public List<Medicine> search(@PathVariable String keyword)
//     {
//    	 return service.search(keyword);
//     }
//         
//}