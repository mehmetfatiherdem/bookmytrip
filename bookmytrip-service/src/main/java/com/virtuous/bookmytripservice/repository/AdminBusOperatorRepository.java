package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBusOperatorRepository extends JpaRepository<BusOperator, Long> {
}
