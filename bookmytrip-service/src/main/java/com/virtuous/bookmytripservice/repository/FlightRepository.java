package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {

    @Query("SELECT p FROM Flight p WHERE p.departureAirport = :departureAirport AND p.arrivalAirport = :arrivalAirport AND DATE(p.departureTime) = :departureDate")
    List<Flight> findFlightsByAndDepartureAirportAndArrivalAirportAndDepartureTimeDate(
            @Param("departureAirport") Airport departureAirport,
            @Param("arrivalAirport") Airport arrivalAirport,
            @Param("departureDate") LocalDate departureDate);

}
