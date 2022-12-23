package com.jenin.catering.service;


import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.model.Log;

import java.util.List;
import java.util.Optional;

public interface LogService {
    List<Log> getLogs();


    void addNewCustomer(Log log);

    Log getLogById(Long event_id);

    List<Log> getLogsByName(String event_name);

    void setExtraServicesInLog(List<ExtraServices> extraServices, Long event_id);
}
