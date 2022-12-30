package com.jenin.catering.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.model.Log;
import com.jenin.catering.repository.ExtraServicesRepository;
import com.jenin.catering.repository.LogRepository;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;
    private final ExtraServicesRepository extraServicesRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository, ExtraServicesRepository extraServicesRepository) {
        this.logRepository = logRepository;
        this.extraServicesRepository = extraServicesRepository;
    }

    public List<Log> getLogs() {
        return logRepository.findAll();
    }

    public void addNewCustomer(Log log) {
        logRepository.save(log);

    }

    public Log getLogById(Long event_id) {
        Optional<Log> logOptional = logRepository.findById(event_id);

        if (logOptional.isEmpty()) {
            throw new RuntimeException("I am a bad boy");
        } else {
            return new Log(
                    logOptional.get().getEvent_id(),
                    logOptional.get().getDate(),
                    logOptional.get().getEvent_name(),
                    logOptional.get().getF_name(),
                    logOptional.get().getL_name(),
                    logOptional.get().getVenue()
            );
        }
    }

    public List<Log> getLogsByName(String event_name) {
        return logRepository.findByEventName(event_name);

    }

    @Transactional
    public void setExtraServicesInLog(List<ExtraServices> extraServices, Long event_id) {
        Optional<Log> log = logRepository.findById(event_id);
        if(log.isEmpty()) {
            throw new RuntimeException("Exception");
        }

        for(ExtraServices e: extraServices) {
            logRepository.insertExtraServices(e.getsId(), event_id);
        }

        //logRepository.setExtraServicesById(extraServices, event_id);
    }

    @Override
    @Transactional
    public void setExtraServicesInLogwithId(List<Long> extraServices, Long event_id) {
        Optional<Log> log = logRepository.findById(event_id);
        if(log.isEmpty()) {
            throw new RuntimeException("Exception");
        }
        for(Long i: extraServices)
            logRepository.insertExtraServices(i, event_id);;
    }
}
