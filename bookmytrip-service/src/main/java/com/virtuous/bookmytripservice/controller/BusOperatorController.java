package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusOperatorSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusOperatorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus-operators")
@RequiredArgsConstructor
public class BusOperatorController {

    private final BusOperatorService busOperatorService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusOperatorResponse> createBusOperator(@Valid @RequestBody BusOperatorSaveRequest request) {
        return GenericResponse.success(busOperatorService.createBusOperator(request), HttpStatus.CREATED);
    }
}
