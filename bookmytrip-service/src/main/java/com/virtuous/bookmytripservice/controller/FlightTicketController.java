package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.FlightTicketBookingRequest;
import com.virtuous.bookmytripservice.dto.request.FlightTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PassengerSaveRequest;
import com.virtuous.bookmytripservice.dto.response.FlightTicketResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.FlightTicketService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight-tickets")
@RequiredArgsConstructor
public class FlightTicketController {

    private final FlightTicketService flightTicketService;

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<FlightTicketResponse> createFlightTicket(@Valid @RequestBody FlightTicketSaveRequest request) {
        return GenericResponse.success(flightTicketService.createFlightTicket(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/book")
    public GenericResponse<List<FlightTicketResponse>> bookFlightTickets(@Valid @RequestBody List<FlightTicketBookingRequest> requests) {
        return GenericResponse.success(flightTicketService.bookFlightTickets(requests), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{flightTicketId}/book")
    public GenericResponse<FlightTicketResponse> bookFlightTicket(@PathVariable String flightTicketId, @Valid @RequestBody PassengerSaveRequest request) {
        return GenericResponse.success(flightTicketService.bookFlightTicket(flightTicketId, request), HttpStatus.OK);
    }
}
