package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPlaneRepository extends JpaRepository<Plane, Long> {
}
