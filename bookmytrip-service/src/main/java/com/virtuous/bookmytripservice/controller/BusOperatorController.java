package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusOperatorPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusOperatorSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusOperatorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus-operators")
@RequiredArgsConstructor
public class BusOperatorController {

    private final BusOperatorService busOperatorService;

    @GetMapping
    public GenericResponse<List<BusOperatorResponse>> getAllBusOperators() {
        return GenericResponse.success(busOperatorService.getAllBusOperators(), HttpStatus.OK);
    }

    @GetMapping("/{busOperatorId}")
    public GenericResponse<BusOperatorResponse> getBusOperatorById(@PathVariable String busOperatorId) {
        return GenericResponse.success(busOperatorService.getBusOperatorById(busOperatorId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusOperatorResponse> createBusOperator(@Valid @RequestBody BusOperatorSaveRequest request) {
        return GenericResponse.success(busOperatorService.createBusOperator(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{busOperatorId}")
    public GenericResponse<BusOperatorResponse> partialUpdateBusOperatorById(@PathVariable String busOperatorId, @Valid @RequestBody BusOperatorPartialUpdateRequest request) {
        return GenericResponse.success(busOperatorService.partialUpdateBusOperatorById(busOperatorId, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{busOperatorId}")
    public GenericResponse<BusOperatorResponse> updateAirlineByAirlineCode(@PathVariable String busOperatorId, @Valid @RequestBody BusOperatorSaveRequest request) {
        return GenericResponse.success(busOperatorService.updateAirlineByAirlineCode(busOperatorId, request), HttpStatus.OK);
    }
}
