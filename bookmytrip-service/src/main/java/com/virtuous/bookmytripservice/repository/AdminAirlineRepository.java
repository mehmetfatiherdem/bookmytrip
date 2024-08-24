package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAirlineRepository extends JpaRepository<Airline, Long> {
}
