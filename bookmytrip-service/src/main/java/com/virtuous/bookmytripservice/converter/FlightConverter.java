package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.FlightResponse;
import com.virtuous.bookmytripservice.model.Flight;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightConverter {

    public static FlightResponse toResponse(Flight flight) {
        return FlightResponse.builder()
                .flightNumber(flight.getFlightNumber())
                .departure(flight.getDeparture())
                .arrival(flight.getArrival())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .status(flight.getStatus().name().toUpperCase())
                .departureAirport(AirportConverter.toResponse(flight.getDepartureAirport()))
                .arrivalAirport(AirportConverter.toResponse(flight.getArrivalAirport()))
                .airline(AirlineConverter.toResponse(flight.getAirline()))
                .plane(PlaneConverter.toResponse(flight.getPlane()))
                .build();
    }

    public static List<FlightResponse> toResponse(List<Flight> flights) {
        return flights
                .stream()
                .map(FlightConverter::toResponse)
                .toList();
    }
}
