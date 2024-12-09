package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.model.Bus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusConverter {
    public static BusResponse toResponse(Bus bus) {
        return BusResponse.builder()
                .id(bus.getId().toString())
                .brand(bus.getBrand())
                .model(bus.getModel())
                .build();

    }

    public static List<BusResponse> toResponse(List<Bus> buses) {
        return buses
                .stream()
                .map(BusConverter::toResponse)
                .toList();
    }
}
