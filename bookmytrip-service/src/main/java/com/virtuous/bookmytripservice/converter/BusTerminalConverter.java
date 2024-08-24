package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.model.BusTerminal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusTerminalConverter {

    public static BusTerminalResponse toResponse(BusTerminal busTerminal) {
        return BusTerminalResponse.builder()
                .name(busTerminal.getName())
                .city(busTerminal.getCity())
                .country(busTerminal.getCountry())
                .build();
    }

    public static List<BusTerminalResponse> toResponse(List<BusTerminal> busTerminals) {
        return busTerminals
                .stream()
                .map(BusTerminalConverter::toResponse)
                .toList();
    }

}
