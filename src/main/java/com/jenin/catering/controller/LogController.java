package com.jenin.catering.controller;

import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.model.Log;
import com.jenin.catering.repository.ExtraServicesRepository;
import com.jenin.catering.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
@RequestMapping("/api/v1")
public class LogController {
    @Autowired
    private final LogService logService;

    @Autowired
    private final ExtraServicesRepository extraServicesRepository;


    public LogController(LogService logService, ExtraServicesRepository extraServicesRepository) {
        this.logService = logService;
        this.extraServicesRepository = extraServicesRepository;
    }

    @GetMapping("/logs")
    public List<Log> logs() {
        return logService.getLogs();
    }

    @GetMapping("/logs/{id}")
    public Log logById(@PathVariable("id") String id) {
        Long iid = Long.parseLong(id);
        return logService.getLogById(iid);
    }

    @GetMapping("/logs/name/{name}")
    public List<Log> logsByEventName(@PathVariable String name) {
        return logService.getLogsByName(name);
    }

    @PostMapping("/logs")
    public void createLog(@RequestBody Log log) {
        logService.addNewCustomer(log);
//        Optional<ExtraServices> a = extraServicesRepository.findById(1L);
//        if(a.isEmpty()) {
//            throw new RuntimeException("Exception");
//        }
//        ExtraServices es= a.get();
//        logService.setExtraServicesInLog(List.of(es), log.getEvent_id());

    }
}
