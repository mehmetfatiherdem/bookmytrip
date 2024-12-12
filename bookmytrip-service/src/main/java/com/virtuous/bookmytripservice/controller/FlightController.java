package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.FlightPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.FlightSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.FlightResponse;
import com.virtuous.bookmytripservice.service.FlightService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public GenericResponse<List<FlightResponse>> getAllFlights() {
        return GenericResponse.success(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/{flightNumber}")
    public GenericResponse<FlightResponse> getFlightByFlightNumber(@PathVariable String flightNumber) {
        return GenericResponse.success(flightService.getFlightByFlightNumber(flightNumber), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<FlightResponse> createFlight(@Valid @RequestBody FlightSaveRequest request) {
        return GenericResponse.success(flightService.createFlight(request), HttpStatus.CREATED);
    }

    @GetMapping("/departures/{departureAirportCode}/arrivals/{arrivalAirportCode}/dates/{date}")
    public GenericResponse<List<FlightResponse>> searchFlights(@PathVariable String departureAirportCode, @PathVariable String arrivalAirportCode, @PathVariable LocalDate date) {
        return GenericResponse.success(flightService.searchFlights(departureAirportCode, arrivalAirportCode, date), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{flightNumber}")
    public GenericResponse<FlightResponse> partialUpdateFlightByFlightNumber(@PathVariable String flightNumber, @Valid @RequestBody FlightPartialUpdateRequest request) {
        return GenericResponse.success(flightService.partialUpdateFlightByFlightNumber(flightNumber, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{flightNumber}")
    public GenericResponse<FlightResponse> updateFlightByFlightNumber(@PathVariable String flightNumber, @Valid @RequestBody FlightSaveRequest request) {
        return GenericResponse.success(flightService.updateFlightByFlightNumber(flightNumber, request), HttpStatus.OK);
    }
}
