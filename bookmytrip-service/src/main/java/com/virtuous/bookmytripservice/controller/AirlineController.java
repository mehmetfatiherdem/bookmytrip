package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirlinePartialUpdateRequest;
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

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{airlineCode}")
    public GenericResponse<AirlineResponse> partialUpdateAirlineByAirlineCode(@PathVariable String airlineCode, @Valid @RequestBody AirlinePartialUpdateRequest request) {
        return GenericResponse.success(airlineService.partialUpdateAirlineByAirlineCode(airlineCode, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{airlineCode}")
    public GenericResponse<AirlineResponse> updateAirlineByAirlineCode(@PathVariable String airlineCode, @Valid @RequestBody AirlineSaveRequest request) {
        return GenericResponse.success(airlineService.updateAirlineByAirlineCode(airlineCode, request), HttpStatus.OK);
    }
}
