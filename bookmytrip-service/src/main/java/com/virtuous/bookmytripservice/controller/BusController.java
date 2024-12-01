package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buses")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @PostMapping
    public GenericResponse<BusResponse> createBus(@Valid @RequestBody BusSaveRequest request) {
        return GenericResponse.success(busService.createBus(request), HttpStatus.CREATED);
    }
}
