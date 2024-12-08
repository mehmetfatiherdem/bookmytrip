package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.model.Airport;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AirportConverter {

    public static AirportResponse toResponse(Airport airport) {
        return AirportResponse.builder()
                .code(airport.getCode())
                .name(airport.getName())
                .country(airport.getCountry())
                .city(airport.getCity())
                .timeZone(airport.getTimezone().name())
                .build();
    }

    public static List<AirportResponse> toResponse(List<Airport> airports) {
        return airports
                .stream()
                .map(AirportConverter::toResponse)
                .toList();
    }
}
