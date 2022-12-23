package com.jenin.catering.service;

import com.jenin.catering.model.Billing;
import com.jenin.catering.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public void createBill(Billing bill) {
        Long event_id = bill.getLog().getEvent_id();
        if(checkIfValidBill(event_id))
            billingRepository.save(bill);
        else {
            throw new RuntimeException("Bill already issued");
        }
    }

    @Override
    public Boolean checkIfValidBill(Long log_event_id) {
        List<Billing> bills = billingRepository.findByLogEventId(log_event_id);
        return bills.isEmpty();
    }
}
