package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusSeatRepository extends JpaRepository<BusSeat, UUID> {
}
