package com.jenin.catering.controller;

import com.jenin.catering.model.Cart;
import com.jenin.catering.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(consumes = "application/json")
    public void saveCart(@RequestBody Cart cart) {
        cartService.storeEntry(cart);

    }

    @GetMapping("/{id}")
    public List<Cart> getCartForEvent(@PathVariable("id") String event_id) {
        Long id = Long.parseLong(event_id);
        return this.cartService.getCartItems(id);
    }
}
