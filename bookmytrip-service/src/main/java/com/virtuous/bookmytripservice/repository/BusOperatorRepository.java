package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusOperatorRepository extends JpaRepository<BusOperator, UUID> {
}
