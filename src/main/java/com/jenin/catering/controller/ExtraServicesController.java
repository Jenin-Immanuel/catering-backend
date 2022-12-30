package com.jenin.catering.controller;

import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.repository.ExtraServicesRepository;
import com.jenin.catering.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class ESRequest {
    List<Long> services;
    Long log_event_id;

    public ESRequest(List<Long> services, Long log_event_id) {
        this.services = services;
        this.log_event_id = log_event_id;
    }
}

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
@RequestMapping("/api/v1/es")
public class ExtraServicesController {
    @Autowired
    private final ExtraServicesRepository extraServicesRepository;

    @Autowired
    private final LogService logService;

    public ExtraServicesController(ExtraServicesRepository extraServicesRepository, LogService logService) {
        this.extraServicesRepository = extraServicesRepository;
        this.logService = logService;
    }

    @GetMapping
    public List<ExtraServices> getAllExtraServices() {
        return extraServicesRepository.findAll();
    }

    @PostMapping
    public void saveExtraService(@RequestBody ESRequest es) {
        logService.setExtraServicesInLogwithId(es.services, es.log_event_id);
    }
}
