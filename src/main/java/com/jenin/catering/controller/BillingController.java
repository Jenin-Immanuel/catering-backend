package com.jenin.catering.controller;

import com.jenin.catering.model.Billing;
import com.jenin.catering.model.Log;
import com.jenin.catering.service.BillingService;
import com.jenin.catering.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

class BillRequest {
    Boolean payStatus;
    String paymentMode;
    Double amount;

    public BillRequest(Boolean payStatus, String paymentMode, Double amount) {
        this.payStatus = payStatus;
        this.paymentMode = paymentMode;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "BillRequest{" +
                "payStatus=" + payStatus +
                ", paymentMode='" + paymentMode + '\'' +
                ", amount=" + amount +
                '}';
    }
}

@RestController
@RequestMapping("/api/v1/bill")
public class BillingController {

    @Autowired
    private  final LogService logService;

    @Autowired
    private final BillingService billingService;

    public BillingController(BillingService billingService, LogService logService) {
        this.billingService = billingService;
        this.logService = logService;
    }

    @PostMapping("/{id}")
    void generateBill(@RequestBody BillRequest bill, @PathVariable String id) {
        Log log = logService.getLogById(Long.parseLong(id));

        Billing newBill = new Billing();
        newBill.setAmount(bill.amount);
        newBill.setPayStatus(bill.payStatus);
        newBill.setPaymentMode(bill.paymentMode);
        newBill.setLog(log);

        billingService.createBill(newBill);
    }
}
