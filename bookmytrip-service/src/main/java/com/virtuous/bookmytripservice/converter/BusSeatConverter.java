package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.dto.response.BusSeatResponse;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.BusSeat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class BusSeatConverter {

    public static BusSeatResponse toResponse(BusSeat busSeat) {
        return BusSeatResponse.builder()
                .number(busSeat.getNumber())
                .build();
    }

    public List<BusSeatResponse> toResponse(List<BusSeat> busSeats) {
        return busSeats
                .stream()
                .map(BusSeatConverter::toResponse)
                .toList();
    }
}
