package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airline;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.PlaneTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PlaneTicketRepository extends JpaRepository<PlaneTicket, UUID> {

    List<PlaneTicket> findPlaneTicketsByAirlineAndDepartureAirportAndArrivalAirportAndDepartureTime(Airline airline, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime);

}
