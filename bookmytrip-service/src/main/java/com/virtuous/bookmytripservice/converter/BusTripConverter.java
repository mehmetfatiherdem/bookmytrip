package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusTripResponse;
import com.virtuous.bookmytripservice.model.BusTrip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BusTripConverter {

    public static BusTripResponse toResponse(BusTrip busTrip) {
        return BusTripResponse.builder()
                .tripNumber(busTrip.getTripNumber())
                .departure(busTrip.getDeparture())
                .arrival(busTrip.getArrival())
                .status(busTrip.getStatus().name().toUpperCase())
                .departureTime(busTrip.getDepartureTime())
                .arrivalTime(busTrip.getArrivalTime())
                .departureBusTerminal(BusTerminalConverter.toResponse(busTrip.getDepartureBusTerminal()))
                .arrivalBusTerminal(BusTerminalConverter.toResponse(busTrip.getArrivalBusTerminal()))
                .bus(BusConverter.toResponse(busTrip.getBus()))
                .busOperator(BusOperatorConverter.toResponse(busTrip.getBusOperator()))
                .build();
    }

    public static List<BusTripResponse> toResponse(List<BusTrip> busTrip) {
        return busTrip
                .stream()
                .map(BusTripConverter::toResponse)
                .toList();
    }

}
