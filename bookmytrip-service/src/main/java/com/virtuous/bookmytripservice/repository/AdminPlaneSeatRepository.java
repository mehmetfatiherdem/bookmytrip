package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.PlaneSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPlaneSeatRepository extends JpaRepository<PlaneSeat, Long> {
}
