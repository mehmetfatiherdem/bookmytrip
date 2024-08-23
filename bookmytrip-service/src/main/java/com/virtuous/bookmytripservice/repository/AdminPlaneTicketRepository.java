package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.PlaneTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPlaneTicketRepository extends JpaRepository<PlaneTicket, Long> {
}
