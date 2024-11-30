package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.TicketResponse;
import com.virtuous.bookmytripservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/mine")
    public GenericResponse<List<TicketResponse>> getAuthUserTickets() {
        return GenericResponse.success(ticketService.getAuthUserTickets(), HttpStatus.OK);
    }
}
