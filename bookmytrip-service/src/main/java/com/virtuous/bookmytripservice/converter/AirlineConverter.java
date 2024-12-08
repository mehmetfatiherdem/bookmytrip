package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.model.Airline;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AirlineConverter {

    public static AirlineResponse toResponse(Airline airline) {
        return AirlineResponse.builder()
                .name(airline.getName())
                .code(airline.getCode())
                .build();
    }

    public static List<AirlineResponse> toResponse(List<Airline> airlines) {
        return airlines
                .stream()
                .map(AirlineConverter::toResponse)
                .toList();
    }
}
