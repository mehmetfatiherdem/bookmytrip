package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BusTripRepository extends JpaRepository<BusTrip, UUID> {
    Optional<BusTrip> findBusTripByTripNumber(String tripNumber);
}
