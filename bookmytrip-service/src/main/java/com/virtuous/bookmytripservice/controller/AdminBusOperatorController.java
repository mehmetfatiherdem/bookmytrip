package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusOperatorSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminBusOperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/bus-operator")
@RequiredArgsConstructor
public class AdminBusOperatorController {

    private final AdminBusOperatorService adminBusOperatorService;

    @PostMapping
    public GenericResponse<BusOperatorResponse> createBusOperator(@RequestBody BusOperatorSaveRequest request) {
        return GenericResponse.success(adminBusOperatorService.createBusOperator(request), HttpStatus.CREATED);
    }
}
