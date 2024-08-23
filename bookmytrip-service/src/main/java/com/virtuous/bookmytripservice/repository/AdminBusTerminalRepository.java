package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusTerminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBusTerminalRepository extends JpaRepository<BusTerminal, Long> {
}
