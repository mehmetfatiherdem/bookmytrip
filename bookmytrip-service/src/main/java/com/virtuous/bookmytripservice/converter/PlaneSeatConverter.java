package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.PlaneSeatResponse;
import com.virtuous.bookmytripservice.model.PlaneSeat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaneSeatConverter {

    public static PlaneSeatResponse toResponse(PlaneSeat planeSeat) {
        return PlaneSeatResponse.builder()
                .number(planeSeat.getNumber())
                .letter(planeSeat.getLetter().name())
                .planeSeatClass(planeSeat.getPlaneSeatClass().name())
                .build();
    }

    public List<PlaneSeatResponse> toResponse(List<PlaneSeat> planeSeats) {
        return planeSeats
                .stream()
                .map(PlaneSeatConverter::toResponse)
                .toList();
    }
}
