package com.cm.med_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.CartItem;
import com.cm.med_app.model.Product;
import com.cm.med_app.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepo;

    private final List<CartItem> cart = new ArrayList<>();

    public void addToCart(String id, int quantity) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // If product already exists in cart, increase quantity
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(id)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        // Add new item to cart
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cart.add(cartItem);
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
    
    public double getCartTotal() {
    	
    	double total= cart.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        return total;
    }
    
    public void removeFromCart(String id) {
        cart.removeIf(item -> item.getProduct().getId().equals(id));
    }
}