package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.TicketConverter;
import com.virtuous.bookmytripservice.dto.response.TicketResponse;
import com.virtuous.bookmytripservice.repository.TicketRepository;
import com.virtuous.bookmytripservice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class TicketService {

    private final JwtUtil jwtUtil;

    private final TicketRepository ticketRepository;

    public List<TicketResponse> getAuthUserTickets() {
        var tickets = ticketRepository.findTicketsByUserId(UUID.fromString(jwtUtil.extractUserId(jwtUtil.extractJwtFromHeader())));
        return TicketConverter.toResponse(tickets);

    }
}
