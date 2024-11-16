package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PlaneTicketSearchRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.service.PlaneTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/plane-tickets")
@RequiredArgsConstructor
public class PlaneTicketController {

    private final PlaneTicketService planeTicketService;

    @PostMapping
    public GenericResponse<PlaneTicketResponse> createPlaneTicket(@RequestBody PlaneTicketSaveRequest request) {
        return GenericResponse.success(planeTicketService.createPlaneTicket(request), HttpStatus.CREATED);
    }

    @GetMapping("/departures/{departureAirportCode}/arrivals/{arrivalAirportCode}/dates/{date}")
    public GenericResponse<List<PlaneTicketResponse>> searchPlaneTickets(@PathVariable String departureAirportCode, @PathVariable String arrivalAirportCode, @PathVariable LocalDate date) {
        return GenericResponse.success(planeTicketService.searchPlaneTickets(departureAirportCode, arrivalAirportCode, date), HttpStatus.OK);
    }
}
