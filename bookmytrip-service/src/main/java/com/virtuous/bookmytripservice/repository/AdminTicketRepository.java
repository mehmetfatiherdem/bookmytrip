package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminTicketRepository extends JpaRepository<Ticket, Long> {
}
