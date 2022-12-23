package com.jenin.catering.repository;

import com.jenin.catering.model.ExtraServices;
import com.jenin.catering.model.Log;
import com.jenin.catering.model.LogPKId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query(value = "SELECT * from log l where l.event_name=?1", nativeQuery = true)
    List<Log> findByEventName(String event_name);

    @Modifying
    @Query(value = "update log l set l.extraServices=?1 where l.event_id=?2", nativeQuery = true)
    void setExtraServicesById(List<ExtraServices> extraServices, Long event_id);

    @Modifying
    @Query(value =  "insert into log_extra_services values(?2, ?1)", nativeQuery = true)
    void insertExtraServices(Long s_id, Long event_id);
}
