package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTripSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTripResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusTripService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus-trips")
@RequiredArgsConstructor
public class BusTripController {

    private final BusTripService busTripService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusTripResponse> createBusTrip(@Valid @RequestBody BusTripSaveRequest request) {
        return GenericResponse.success(busTripService.createBusTrip(request), HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<BusTripResponse>> getAllBusTrips() {
        return GenericResponse.success(busTripService.getAllBusTrips(), HttpStatus.OK);
    }
}
