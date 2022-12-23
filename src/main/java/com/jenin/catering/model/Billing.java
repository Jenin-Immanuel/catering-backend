package com.jenin.catering.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "billing")
public class Billing {
    @Id
    @Column(name = "bill_id")
    @SequenceGenerator(name = "billing_sequence", sequenceName = "billing_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_generator")
    private Long billId;

    @Column(name = "pay_status")
    private Boolean payStatus;

    @Column(name = "payment_mode")
    private String paymentMode;

    private Double  amount;

    @OneToOne
    @JoinColumn(name = "log_event_id", unique = true)
    private Log log;



    public Billing() {}

    public Billing(Long billId, Boolean payStatus, String paymentMode, Double amount) {
        this.billId = billId;
        this.payStatus = payStatus;
        this.paymentMode = paymentMode;
        this.amount = amount;
    }

    public Billing(Boolean payStatus, String paymentMode, Double amount) {
        this.payStatus = payStatus;
        this.paymentMode = paymentMode;
        this.amount = amount;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billing billing = (Billing) o;
        return Objects.equals(billId, billing.billId) && Objects.equals(payStatus, billing.payStatus) && Objects.equals(paymentMode, billing.paymentMode) && Objects.equals(amount, billing.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, payStatus, paymentMode, amount);
    }
}
