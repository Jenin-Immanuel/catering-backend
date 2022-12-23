package com.jenin.catering.model;



import javax.persistence.*;

@Entity
@Table(name = "cart")
@IdClass(CartPKId.class)
public class Cart {

//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "log_event_id")
//    private Log log;
//
//    @Id
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "menu_item_id")
//    private Menu menu;

    @Id
    @Column(name = "log_event_id")
    private Long log_event_id;

    @Id
    @Column(name = "menu_item_id")
    private Long menu_item_id;

    @Column(name = "b_count")
    private Integer bCount;

    @Column(name = "l_count")
    private Integer lCount;

    @Column(name = "d_count")
    private Integer dCount;

    @Column(name = "total_cost")
    private Double totalCost;

    public Cart() {}

    public Cart(Long log_event_id, Long menu_item_id, Integer bCount, Integer lCount, Integer dCount, Double totalCost) {
        this.log_event_id = log_event_id;
        this.menu_item_id = menu_item_id;
        this.bCount = bCount;
        this.lCount = lCount;
        this.dCount = dCount;
        this.totalCost = totalCost;
    }

    public Long getLog_event_id() {
        return log_event_id;
    }

    public void setLog_event_id(Long log_event_id) {
        this.log_event_id = log_event_id;
    }

    public Long getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(Long menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public Integer getbCount() {
        return bCount;
    }

    public void setbCount(Integer bCount) {
        this.bCount = bCount;
    }

    public Integer getlCount() {
        return lCount;
    }

    public void setlCount(Integer lCount) {
        this.lCount = lCount;
    }

    public Integer getdCount() {
        return dCount;
    }

    public void setdCount(Integer dCount) {
        this.dCount = dCount;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}

