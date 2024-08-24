package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminBusRepository extends JpaRepository<Bus, Long> {
}
