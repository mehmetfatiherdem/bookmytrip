package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.AdminBusTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/tickets/bus-ticket")
@RequiredArgsConstructor
public class AdminBusTicketController {

    private final AdminBusTicketService adminBusTicketService;

    @PostMapping
    public GenericResponse<BusTicketResponse> createBusTicket(@RequestBody BusTicketSaveRequest request) {
        return GenericResponse.success(adminBusTicketService.createBusTicket(request), HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<BusTicketResponse>> getAllBusTickets() {
        return GenericResponse.success(adminBusTicketService.getAllBusTickets(), HttpStatus.OK);
    }
}
