package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Plane;
import com.virtuous.bookmytripservice.repository.AdminPlaneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminPlaneService {

    private final AdminPlaneRepository adminPlaneRepository;

    public PlaneResponse createPlane(PlaneSaveRequest request) {
        Plane plane = new Plane();
        plane.setBrand(request.getBrand());
        plane.setModel(request.getModel());

        adminPlaneRepository.save(plane);

        return PlaneConverter.toResponse(plane);
    }

    public Plane findPlaneById(Long id) {
        Optional<Plane> plane = adminPlaneRepository.findById(id);

        if (plane.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.PLANE_NOT_FOUND);
        }

        return plane.get();
    }
}
