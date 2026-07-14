package com.cm.med_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cm.med_app.model.Appointment;
import com.cm.med_app.model.Product;
import com.cm.med_app.service.AppointmentService;
import com.cm.med_app.service.CartService;
import com.cm.med_app.service.MedicineAIService;
//import com.cm.med_app.service.MedicineAIService;
import com.cm.med_app.service.ProductService;

@Controller
public class ViewController {

    @Autowired
    private ProductService productService;

     @Autowired
     private MedicineAIService medicineAIService;

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("products", productService.getMedicines());
        model.addAttribute("supplements", productService.getSupplements());

        return "views/index";
    }

    @PostMapping("/recommend")
    @ResponseBody
    public String recommend(@RequestParam String query) {

        return medicineAIService.recommendMedicine(query);
    }

    @GetMapping("/add")
    public String showAddPage() {
       
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {

        productService.add(product);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable String id, Model model) {

        Product product = productService.getById(id);

        if (product == null) {
            return "redirect:/";
        }

        model.addAttribute("product", product);

        return "edit-product";
    }

//    @PostMapping("/edit/{id}")
//    public String editProduct(@PathVariable String id,
//                              @ModelAttribute Product product) {
//
//        productService.update(id, product);
//
//        return "redirect:/";
//    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable String id, Model model) {

        Product product = productService.getById(id);

        if (product == null) {
            return "redirect:/";
        }

        model.addAttribute("product", product);

        return "views/shop-single";
    }

    @GetMapping("/appointment")
    public String appointmentForm(Model model) {

        model.addAttribute("appointment", new Appointment());

        return "views/contact";
    }

    @PostMapping("/appointment")
    public String saveAppointment(@ModelAttribute Appointment appointment,
                                  Model model) {

        Appointment newAppointment = appointmentService.saveAppointment(appointment);

        appointmentService.sendAppointmentEmail(newAppointment);

        model.addAttribute("ticket", newAppointment);

        return "ticket";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {

        model.addAttribute("products", productService.search(keyword));
        model.addAttribute("keyword", keyword);

        return "views/index";
    }
    
    @GetMapping("/thankyou")
    public String showTy() {

        return "views/thankyou";
    }
    
    @GetMapping("/shop")
    public String showShop(Model model) {

    	model.addAttribute("products",productService.getAll());
        return "views/shop";
    }
    
    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("cartitems", cartService.getCart());
        model.addAttribute("total", cartService.getCartTotal());
        return "views/cart";
    }
    
    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable String id,
                            @RequestParam(defaultValue = "1") int quantity) {

        cartService.addToCart(id, quantity);
        return "redirect:/cart";
    }
    
    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable String id) {
        cartService.removeFromCart(id);
        return "redirect:/cart";
    }
    
    @GetMapping("/checkout")
    public String checkout(Model model)
    {
    	 model.addAttribute("cartitems", cartService.getCart());
         model.addAttribute("total", cartService.getCartTotal());
    	return "views/checkout";
    }
    
}