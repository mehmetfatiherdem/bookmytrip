package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusSeatResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus-seats")
@RequiredArgsConstructor

public class BusSeatController {
    private final BusSeatService busSeatService;

    @PostMapping
    public GenericResponse<BusSeatResponse> create(@RequestBody BusSeatSaveRequest request) {
        return GenericResponse.success(busSeatService.createBusSeat(request), HttpStatus.CREATED);
    }
}
