package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminAirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/airport")
@RequiredArgsConstructor
public class AdminAirportController {

    private final AdminAirportService adminAirportService;

    @PostMapping
    public GenericResponse<AirportResponse> createAirport(@RequestBody AirportSaveRequest request) {
        return GenericResponse.success(adminAirportService.createAirport(request), HttpStatus.CREATED);
    }
}
