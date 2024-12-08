package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirlineSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AirlineService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public GenericResponse<List<AirlineResponse>> getAirlines() {
        return GenericResponse.success(airlineService.getAllAirlines(), HttpStatus.OK);
    }

    @GetMapping("/{airlineCode}")
    public GenericResponse<AirlineResponse> getAirlineByCode(@PathVariable String airlineCode) {
        return GenericResponse.success(airlineService.getAirlineByCode(airlineCode), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<AirlineResponse> createAirline(@Valid @RequestBody AirlineSaveRequest request) {
        return GenericResponse.success(airlineService.createAirline(request), HttpStatus.CREATED);
    }
}
