package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusTicketRepository extends JpaRepository<BusTicket, UUID> {
}
