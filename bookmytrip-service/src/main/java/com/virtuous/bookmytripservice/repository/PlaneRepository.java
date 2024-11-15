package com.virtuous.bookmytripservice.repository;

import com.virtuous.bookmytripservice.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
