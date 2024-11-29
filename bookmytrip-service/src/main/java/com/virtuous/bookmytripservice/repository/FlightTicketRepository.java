package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightTicketRepository extends JpaRepository<FlightTicket, UUID> {
}
