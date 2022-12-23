package com.jenin.catering.model;

import java.io.Serializable;
import java.util.Objects;

public class CartPKId implements Serializable {
    private Long log_event_id;
    private Long menu_item_id;

    public CartPKId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartPKId cartPKId = (CartPKId) o;
        return Objects.equals(log_event_id, cartPKId.log_event_id) && Objects.equals(menu_item_id, cartPKId.menu_item_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(log_event_id, menu_item_id);
    }
}
