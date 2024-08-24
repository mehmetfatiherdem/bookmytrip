package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.model.Plane;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaneConverter {

    public static PlaneResponse toResponse(Plane plane) {
        return PlaneResponse.builder()
                .brand(plane.getBrand())
                .model(plane.getModel())
                .build();
    }

    public List<PlaneResponse> toResponse(List<Plane> planes) {
        return planes
                .stream()
                .map(PlaneConverter::toResponse)
                .toList();
    }
}
