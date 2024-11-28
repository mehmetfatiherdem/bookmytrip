package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.TripResponse;
import com.virtuous.bookmytripservice.model.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TripConverter {

    public static TripResponse toResponse(Trip trip) {
        return  TripResponse.builder()
                .id(trip.getId().toString())
                .departure(trip.getDeparture())
                .arrival(trip.getArrival())
                .status(trip.getStatus().name())
                .departureTime(trip.getDepartureTime())
                .arrivalTime(trip.getArrivalTime())
                .build();
    }

    public static List<TripResponse> toResponse(List<Trip> trips) {
        return trips
                .stream()
                .map(TripConverter::toResponse)
                .toList();
    }
}
