package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.TripStatusUpdateRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.TripResponse;
import com.virtuous.bookmytripservice.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PatchMapping("/{tripId}")
    public GenericResponse<TripResponse> cancelTrip(@PathVariable String tripId, @RequestBody TripStatusUpdateRequest request) {
        return GenericResponse.success(tripService.updateTripStatus(tripId, request), HttpStatus.OK);
    }
}
