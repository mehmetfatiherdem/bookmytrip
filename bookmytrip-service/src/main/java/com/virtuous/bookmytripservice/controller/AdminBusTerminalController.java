package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminBusTerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/bus-terminal")
@RequiredArgsConstructor
public class AdminBusTerminalController {

    private final AdminBusTerminalService adminBusTerminalService;

    @PostMapping()
    public GenericResponse<BusTerminalResponse> createBlog(@RequestBody BusTerminalSaveRequest request) {
        return GenericResponse.success(adminBusTerminalService.createBusTerminal(request), HttpStatus.CREATED);
    }
}
