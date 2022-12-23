package com.jenin.catering.repository;

import com.jenin.catering.model.ExtraServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraServicesRepository extends JpaRepository<ExtraServices, Long> {

}
