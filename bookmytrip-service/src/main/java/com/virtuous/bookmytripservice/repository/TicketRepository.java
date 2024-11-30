package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findTicketsByUserId(UUID userId);
}
