package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
