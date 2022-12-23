package com.jenin.catering.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @SequenceGenerator(name = "menu_sequence", sequenceName = "menu_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_sequence")
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price_per_plate")
    private Double pricePerPlate;

    public Menu() {}

    public Menu(Long itemId, String itemName, Double pricePerPlate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.pricePerPlate = pricePerPlate;
    }

    public Menu(String itemName, Double pricePerPlate) {
        this.itemName = itemName;
        this.pricePerPlate = pricePerPlate;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPricePerPlate() {
        return pricePerPlate;
    }

    public void setPricePerPlate(Double pricePerPlate) {
        this.pricePerPlate = pricePerPlate;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", pricePerPlate=" + pricePerPlate +
                '}';
    }
}
