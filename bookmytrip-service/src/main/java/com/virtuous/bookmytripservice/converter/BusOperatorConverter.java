package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.model.BusOperator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusOperatorConverter {

    public static BusOperatorResponse toResponse(BusOperator busOperator) {
        return BusOperatorResponse.builder()
                .name(busOperator.getName())
                .build();
    }

    public List<BusOperatorResponse> toResponse(List<BusOperator> busOperators) {
        return busOperators
                .stream()
                .map(BusOperatorConverter::toResponse)
                .toList();
    }
}
