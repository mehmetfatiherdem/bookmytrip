package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.model.BusTicket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusTicketConverter {
    public static BusTicketResponse toResponse(BusTicket busTicket) {
        return BusTicketResponse.builder()
                .trip(TripConverter.toResponse(busTicket.getTrip()))
                .price(busTicket.getPrice())
                .busSeat(BusSeatConverter.toResponse(busTicket.getBusSeat()))
                .ticketStatus(busTicket.getStatus().name())
                .platform(busTicket.getPlatform())
                .build();
    }

    public static List<BusTicketResponse> toResponse(List<BusTicket> busTickets) {
        return busTickets.stream()
                .map(BusTicketConverter::toResponse)
                .toList();
    }
}
