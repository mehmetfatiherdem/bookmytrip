package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
