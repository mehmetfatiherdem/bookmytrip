package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.TicketResponse;
import com.virtuous.bookmytripservice.service.TicketService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public GenericResponse<List<TicketResponse>> getAllTickets() {
        return GenericResponse.success(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public GenericResponse<TicketResponse> getTicketById(@PathVariable String ticketId) {
        return GenericResponse.success(ticketService.getTicketById(ticketId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @GetMapping("/mine")
    public GenericResponse<List<TicketResponse>> getAuthUserTickets() {
        return GenericResponse.success(ticketService.getAuthUserTickets(), HttpStatus.OK);
    }
}
