package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBusTicketRepository extends JpaRepository<BusTicket, Long> {
}
