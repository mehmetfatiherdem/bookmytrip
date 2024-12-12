package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneConverter;
import com.virtuous.bookmytripservice.dto.request.PlanePartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.PlaneSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Plane;
import com.virtuous.bookmytripservice.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public PlaneResponse partialUpdatePlaneById(String planeId, PlanePartialUpdateRequest request) {
        var plane = findPlaneById(UUID.fromString(planeId));

        if(request.getBrand().isPresent()) plane.setBrand(request.getBrand().get());
        if(request.getModel().isPresent()) plane.setModel(request.getModel().get());

        planeRepository.save(plane);

        return PlaneConverter.toResponse(plane);
    }

    public PlaneResponse updatePlaneById(String planeId, PlaneSaveRequest request) {
        var plane = findPlaneById(UUID.fromString(planeId));

        plane.setBrand(request.getBrand());
        plane.setModel(request.getModel());

        planeRepository.save(plane);

        return PlaneConverter.toResponse(plane);
    }

    public List<PlaneResponse> getAllPlanes() {
        var planes = planeRepository.findAll();
        return PlaneConverter.toResponse(planes);
    }

    public PlaneResponse getPlaneById(String planeId) {
        var plane = findPlaneById(UUID.fromString(planeId));
        return PlaneConverter.toResponse(plane);
    }

    public PlaneResponse createPlane(PlaneSaveRequest request) {
        Plane plane = new Plane();
        plane.setBrand(request.getBrand());
        plane.setModel(request.getModel());

        planeRepository.save(plane);

        return PlaneConverter.toResponse(plane);
    }

    public Plane findPlaneById(UUID id) {
        Optional<Plane> plane = planeRepository.findById(id);

        if (plane.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.PLANE_NOT_FOUND);
        }

        return plane.get();
    }
}
