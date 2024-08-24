package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.AirlineSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminAirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/airline")
@RequiredArgsConstructor
public class AdminAirlineController {

    private final AdminAirlineService adminAirlineService;

    @PostMapping
    public GenericResponse<AirlineResponse> createAirline(@RequestBody AirlineSaveRequest request) {
        return GenericResponse.success(adminAirlineService.createAirline(request), HttpStatus.CREATED);
    }
}
