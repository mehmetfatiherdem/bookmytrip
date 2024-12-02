package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.TripStatusUpdateRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.TripResponse;
import com.virtuous.bookmytripservice.service.TripService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping
    public GenericResponse<List<TripResponse>> getAllTrips() {
        return GenericResponse.success(tripService.getAllTrips(), HttpStatus.OK);
    }

    @GetMapping("/departure/{departure}/arrival/{arrival}")
    public GenericResponse<List<TripResponse>> getTripsByDepartureAndDestination(@PathVariable String departure, @PathVariable String arrival) {
        return GenericResponse.success(tripService.getTripsByDestinationAndArrival(departure, arrival), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{tripId}")
    public GenericResponse<TripResponse> cancelTrip(@PathVariable String tripId, @Valid @RequestBody TripStatusUpdateRequest request) {
        return GenericResponse.success(tripService.updateTripStatus(tripId, request), HttpStatus.OK);
    }
}
