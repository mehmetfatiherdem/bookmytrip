package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {

    @Query("SELECT f FROM Flight f WHERE f.departureAirport = :departureAirport " +
            "AND f.arrivalAirport = :arrivalAirport " +
            "AND FUNCTION('DATE', f.departureTime) = :departureDate")
    List<Flight> findFlightsByDepartureAirportAndArrivalAirportAndDepartureTimeDate(
            @Param("departureAirport") Airport departureAirport,
            @Param("arrivalAirport") Airport arrivalAirport,
            @Param("departureDate") ZonedDateTime departureDate);



}
