package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buses")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @GetMapping
    public GenericResponse<List<BusResponse>> getAllBusses() {
        return GenericResponse.success(busService.getAllBusses(), HttpStatus.OK);
    }

    @GetMapping("/{busId}")
    public GenericResponse<BusResponse> getBusById(@PathVariable String busId) {
        return GenericResponse.success(busService.getBusById(busId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusResponse> createBus(@Valid @RequestBody BusSaveRequest request) {
        return GenericResponse.success(busService.createBus(request), HttpStatus.CREATED);
    }
}
