package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusRepository extends JpaRepository<Bus, UUID> {
}
