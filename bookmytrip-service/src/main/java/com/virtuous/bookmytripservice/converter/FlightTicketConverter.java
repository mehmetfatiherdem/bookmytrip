package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.FlightTicketResponse;
import com.virtuous.bookmytripservice.model.FlightTicket;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightTicketConverter {

    public static FlightTicketResponse toResponse(FlightTicket flightTicket) {
        return FlightTicketResponse.builder()
                //.passenger(PassengerConverter.toResponse(flightTicket.getPassenger()))
                .trip(TripConverter.toResponse(flightTicket.getTrip()))
                .price(flightTicket.getPrice())
                .ticketStatus(flightTicket.getStatus().name())
                .planeSeat(PlaneSeatConverter.toResponse(flightTicket.getPlaneSeat()))
                .boardingGate(flightTicket.getBoardingGate())
                .build();
    }
}
