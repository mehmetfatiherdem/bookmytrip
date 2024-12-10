package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirportPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AirportService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public GenericResponse<List<AirportResponse>> getAllAirports() {
        return GenericResponse.success(airportService.getAllAirports(), HttpStatus.OK);
    }

    @GetMapping("/{airportCode}")
    public GenericResponse<AirportResponse> getAirportByCode(@PathVariable String airportCode) {
        return GenericResponse.success(airportService.getAirportByCode(airportCode), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<AirportResponse> createAirport(@Valid @RequestBody AirportSaveRequest request) {
        return GenericResponse.success(airportService.createAirport(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{airportCode}")
    public GenericResponse<AirportResponse> partialUpdateAirportByAirportCode(@PathVariable String airportCode, @Valid @RequestBody AirportPartialUpdateRequest request) {
        return GenericResponse.success(airportService.partialUpdateAirportByAirportCode(airportCode, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{airportCode}")
    public GenericResponse<AirportResponse> updateAirlineByAirlineCode(@PathVariable String airportCode, @Valid @RequestBody AirportSaveRequest request) {
        return GenericResponse.success(airportService.updateAirlineByAirlineCode(airportCode, request), HttpStatus.OK);
    }
}
