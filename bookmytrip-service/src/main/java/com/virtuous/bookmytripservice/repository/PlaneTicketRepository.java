package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.PlaneTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PlaneTicketRepository extends JpaRepository<PlaneTicket, UUID> {

    List<PlaneTicket> findPlaneTicketsByAndDepartureAirportAndArrivalAirportAndDepartureTimeDate(Airport departureAirport, Airport arrivalAirport, LocalDate departureTime);

}
