package com.jenin.catering.service;


import com.jenin.catering.model.Billing;

import java.util.List;

public interface BillingService {
    void createBill(Billing bill);

    Boolean checkIfValidBill(Long log_event_id);
    // List<Billing> findBillByBillId();
}
