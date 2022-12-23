package com.jenin.catering.service;


import com.jenin.catering.model.Cart;
import com.jenin.catering.model.Log;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartService {

    void storeEntry(Cart cart);

    List<Cart> getCartItems(Long event_id);
}
