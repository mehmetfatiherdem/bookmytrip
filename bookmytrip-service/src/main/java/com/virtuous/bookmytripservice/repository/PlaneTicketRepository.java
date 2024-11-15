package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.PlaneTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneTicketRepository extends JpaRepository<PlaneTicket, UUID> {
}
