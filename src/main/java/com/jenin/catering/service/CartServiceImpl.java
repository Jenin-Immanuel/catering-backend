package com.jenin.catering.service;

import com.jenin.catering.model.Cart;
import com.jenin.catering.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public void storeEntry(Cart cart) {
        this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartItems(Long event_id) {
        return cartRepository.findCartItemsByEventId(event_id);
    }
}
