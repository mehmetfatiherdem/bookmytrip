package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusTerminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusTerminalRepository extends JpaRepository<BusTerminal, UUID> {
}
