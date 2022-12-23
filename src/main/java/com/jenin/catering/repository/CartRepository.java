package com.jenin.catering.repository;

import com.jenin.catering.model.Cart;
import com.jenin.catering.model.CartPKId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartPKId> {

    @Query(value = "SELECT * from cart c where c.log_event_id=?1", nativeQuery = true)
    List<Cart> findCartItemsByEventId(Long event_id);
}
