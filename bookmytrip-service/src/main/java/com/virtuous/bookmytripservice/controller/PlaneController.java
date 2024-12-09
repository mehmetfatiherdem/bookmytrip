package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.service.PlaneService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
@RequiredArgsConstructor
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping
    public GenericResponse<List<PlaneResponse>> getAllPlanes() {
        return GenericResponse.success(planeService.getAllPlanes(), HttpStatus.OK);
    }

    @GetMapping("/{planeId}")
    public GenericResponse<PlaneResponse> getAllPlanes(@PathVariable String planeId) {
        return GenericResponse.success(planeService.getPlaneById(planeId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<PlaneResponse> createPlane(@Valid @RequestBody PlaneSaveRequest request) {
        return GenericResponse.success(planeService.createPlane(request), HttpStatus.CREATED);
    }
}
