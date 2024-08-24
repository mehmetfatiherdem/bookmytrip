package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.BusSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBusSeatRepository extends JpaRepository<BusSeat, Long> {
}
