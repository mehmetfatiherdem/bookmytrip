package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.FlightTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PassengerSaveRequest;
import com.virtuous.bookmytripservice.dto.response.FlightTicketResponse;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.FlightTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/flight-tickets")
@RequiredArgsConstructor
public class FlightTicketController {

    private final FlightTicketService flightTicketService;

    @PostMapping
    public GenericResponse<FlightTicketResponse> createFlightTicket(@RequestBody FlightTicketSaveRequest request) {
        return GenericResponse.success(flightTicketService.createFlightTicket(request), HttpStatus.CREATED);
    }

    @PatchMapping("/{flightTicketId}/book")
    public GenericResponse<FlightTicketResponse> bookFlightTicket(@PathVariable String flightTicketId, @RequestBody PassengerSaveRequest request) {
        return GenericResponse.success(flightTicketService.bookFlightTicket(flightTicketId, request), HttpStatus.OK);
    }
}
