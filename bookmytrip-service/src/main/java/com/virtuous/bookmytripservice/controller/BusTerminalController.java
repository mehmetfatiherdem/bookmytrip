package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusTerminalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bus-terminals")
@RequiredArgsConstructor
public class BusTerminalController {

    private final BusTerminalService busTerminalService;

    @PostMapping
    public GenericResponse<BusTerminalResponse> createBlog(@Valid @RequestBody BusTerminalSaveRequest request) {
        return GenericResponse.success(busTerminalService.createBusTerminal(request), HttpStatus.CREATED);
    }
}
