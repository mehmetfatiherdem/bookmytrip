package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAirportRepository extends JpaRepository<Airport, Long> {
}
