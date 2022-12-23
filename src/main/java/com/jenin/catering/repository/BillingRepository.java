package com.jenin.catering.repository;

import com.jenin.catering.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

    @Query(value = "SELECT * from billing b where b.log_event_id=?1", nativeQuery = true)
    List<Billing> findByLogEventId(Long log_event_id);
}
