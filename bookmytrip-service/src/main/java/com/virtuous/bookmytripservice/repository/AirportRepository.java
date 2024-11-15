package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {
}
