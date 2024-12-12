package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTerminalPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusTerminalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus-terminals")
@RequiredArgsConstructor
public class BusTerminalController {

    private final BusTerminalService busTerminalService;

    @GetMapping
    public GenericResponse<List<BusTerminalResponse>> getAllBusTerminals() {
        return GenericResponse.success(busTerminalService.getAllBusTerminals(), HttpStatus.OK);
    }

    @GetMapping("/{busTermianlId}")
    public GenericResponse<BusTerminalResponse> getBusTerminalById(@PathVariable String busTermianlId) {
        return GenericResponse.success(busTerminalService.getBusTerminalById(busTermianlId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusTerminalResponse> createBlog(@Valid @RequestBody BusTerminalSaveRequest request) {
        return GenericResponse.success(busTerminalService.createBusTerminal(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{busTerminalId}")
    public GenericResponse<BusTerminalResponse> partialUpdateBusTerminalById(@PathVariable String busTerminalId, @RequestBody BusTerminalPartialUpdateRequest request) {
        return GenericResponse.success(busTerminalService.partialUpdateBusTerminalById(busTerminalId, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{busTerminalId}")
    public GenericResponse<BusTerminalResponse> updateBusTerminalById(@PathVariable String busTerminalId, @RequestBody BusTerminalSaveRequest request) {
        return GenericResponse.success(busTerminalService.updateBusTerminalById(busTerminalId, request), HttpStatus.OK);
    }
}
