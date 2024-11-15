package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}
