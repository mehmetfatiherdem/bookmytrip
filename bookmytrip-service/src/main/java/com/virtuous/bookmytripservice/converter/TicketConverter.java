package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.TicketResponse;
import com.virtuous.bookmytripservice.model.Ticket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketConverter {

    public static TicketResponse toResponse(Ticket ticket) {
        return TicketResponse.builder()
                .ticketId(ticket.getId().toString())
                .ticketStatus(ticket.getStatus().name())
                .ticketPrice(ticket.getPrice())
                .passenger(PassengerConverter.toResponse(ticket.getPassenger()))
                .trip(TripConverter.toResponse(ticket.getTrip()))
                .build();
    }

    public static List<TicketResponse> toResponse(List<Ticket> tickets) {
        return tickets.stream()
                .map(TicketConverter::toResponse)
                .toList();
    }
}
