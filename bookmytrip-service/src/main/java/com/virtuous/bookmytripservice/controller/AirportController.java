package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AirportService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService adminAirportService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<AirportResponse> createAirport(@Valid @RequestBody AirportSaveRequest request) {
        return GenericResponse.success(adminAirportService.createAirport(request), HttpStatus.CREATED);
    }
}
