package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirlineSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AirlineService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService adminAirlineService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<AirlineResponse> createAirline(@Valid @RequestBody AirlineSaveRequest request) {
        return GenericResponse.success(adminAirlineService.createAirline(request), HttpStatus.CREATED);
    }
}
