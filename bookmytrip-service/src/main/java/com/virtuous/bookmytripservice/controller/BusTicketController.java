package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.BusTicketBookingRequest;
import com.virtuous.bookmytripservice.dto.request.BusTicketPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.BusTicketService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bus-tickets")
public class BusTicketController {

    private final BusTicketService busTicketService;

    @GetMapping
    public GenericResponse<List<BusTicketResponse>> getAllBusTickets() {
        return GenericResponse.success(busTicketService.getAllBusTickets(), HttpStatus.OK);
    }

    @GetMapping("/{busTicketId}")
    public GenericResponse<BusTicketResponse> getBusTicketById(@PathVariable String busTicketId) {
        return GenericResponse.success(busTicketService.getBusTicketById(busTicketId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<BusTicketResponse> createBusTicket(@Valid @RequestBody BusTicketSaveRequest request) {
        return GenericResponse.success(busTicketService.createBusTicket(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/book")
    public GenericResponse<List<BusTicketResponse>> bookBusTickets(@Valid @RequestBody List<BusTicketBookingRequest> requests) {
        return GenericResponse.success(busTicketService.bookBusTickets(requests), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{busTicketId}")
    public GenericResponse<BusTicketResponse> partialUpdateBusTicketById(@PathVariable String busTicketId, @Valid @RequestBody BusTicketPartialUpdateRequest request) {
        return GenericResponse.success(busTicketService.partialUpdateBusTicketById(busTicketId, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{busTicketId}")
    public GenericResponse<BusTicketResponse> updateBusTicketById(@PathVariable String busTicketId, @Valid @RequestBody BusTicketSaveRequest request) {
        return GenericResponse.success(busTicketService.updateBusTicketById(busTicketId, request), HttpStatus.OK);
    }
}
