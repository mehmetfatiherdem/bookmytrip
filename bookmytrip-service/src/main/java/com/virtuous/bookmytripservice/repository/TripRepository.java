package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
    List<Trip> findTripsByDepartureAndAndArrivalIgnoreCase(String departure, String arrival);

    @Query("SELECT t FROM Trip t WHERE FUNCTION('DATE', t.departureTime) = :departureDate")
    List<Trip> findTripsByDepartureTimeDate(@Param("departureDate") ZonedDateTime departureDate);
}
