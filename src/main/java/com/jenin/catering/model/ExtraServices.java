package com.jenin.catering.model;

import javax.persistence.*;

@Entity
@Table(name = "extra_services")
public class ExtraServices {
    @Id
    @Column(name = "s_id")
    private Long sId;

    @Column(name = "service_name")
    private String serviceName;

    private Double cost;

    public ExtraServices(Long sId, String serviceName, Double cost) {
        this.sId = sId;
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public ExtraServices() {}

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ExtraServices{" +
                "sId=" + sId +
                ", serviceName='" + serviceName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
