package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusSeatPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusSeatResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusSeatService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus-seats")
@RequiredArgsConstructor

public class BusSeatController {
    private final BusSeatService busSeatService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusSeatResponse> create(@Valid @RequestBody BusSeatSaveRequest request) {
        return GenericResponse.success(busSeatService.createBusSeat(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{busSeatId}")
    public GenericResponse<BusSeatResponse> partialUpdateBusSeatById(@PathVariable String busSeatId, @Valid @RequestBody BusSeatPartialUpdateRequest request) {
        return GenericResponse.success(busSeatService.partialUpdateBusSeatById(busSeatId, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{busSeatId}")
    public GenericResponse<BusSeatResponse> updateBusSeatById(@PathVariable String busSeatId, @Valid @RequestBody BusSeatSaveRequest request) {
        return GenericResponse.success(busSeatService.updateBusSeatById(busSeatId, request), HttpStatus.OK);
    }
}
