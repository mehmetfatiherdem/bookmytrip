package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminBusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/bus")
@RequiredArgsConstructor
public class AdminBusController {

    private final AdminBusService adminBusService;

    @PostMapping
    public GenericResponse<BusResponse> createBus(@RequestBody BusSaveRequest request) {
        return GenericResponse.success(adminBusService.createBus(request), HttpStatus.CREATED);
    }
}
