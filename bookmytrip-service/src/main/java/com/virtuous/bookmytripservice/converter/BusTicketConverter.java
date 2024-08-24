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
                .tripNumber(busTicket.getTripNumber())
                .departure(busTicket.getDeparture())
                .arrival(busTicket.getArrival())
                .departureTime(busTicket.getDepartureTime())
                .arrivalTime(busTicket.getArrivalTime())
                .price(busTicket.getPrice())
                .departureBusTerminal(BusTerminalConverter.toResponse(busTicket.getDepartureBusTerminal()))
                .arrivalBusTerminal(BusTerminalConverter.toResponse(busTicket.getArrivalBusTerminal()))
                .bus(BusConverter.toResponse(busTicket.getBus()))
                .busOperator(BusOperatorConverter.toResponse(busTicket.getBusOperator()))
                .build();
    }

    public static List<BusTicketResponse> toResponse(List<BusTicket> busTicket) {
        return busTicket
                .stream()
                .map(BusTicketConverter::toResponse)
                .toList();
    }

}
