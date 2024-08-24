package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.model.PlaneTicket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaneTicketConverter {

    public static PlaneTicketResponse toResponse(PlaneTicket planeTicket) {
        return PlaneTicketResponse.builder()
                .flightNumber(planeTicket.getFlightNumber())
                .departure(planeTicket.getDeparture())
                .arrival(planeTicket.getArrival())
                .departureTime(planeTicket.getDepartureTime())
                .arrivalTime(planeTicket.getArrivalTime())
                .price(planeTicket.getPrice())
                .departureAirport(AirportConverter.toResponse(planeTicket.getDepartureAirport()))
                .arrivalAirport(AirportConverter.toResponse(planeTicket.getArrivalAirport()))
                .airline(AirlineConverter.toResponse(planeTicket.getAirline()))
                .plane(PlaneConverter.toResponse(planeTicket.getPlane()))
                .build();
    }

    public static List<PlaneTicketResponse> toResponse(List<PlaneTicket> planeTickets) {
        return planeTickets
                .stream()
                .map(PlaneTicketConverter::toResponse)
                .toList();
    }
}
