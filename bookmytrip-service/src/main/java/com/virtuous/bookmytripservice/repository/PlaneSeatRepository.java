package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.PlaneSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneSeatRepository extends JpaRepository<PlaneSeat, UUID> {
}
