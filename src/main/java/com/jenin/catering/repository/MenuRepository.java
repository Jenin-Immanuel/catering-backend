package com.jenin.catering.repository;

import com.jenin.catering.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
