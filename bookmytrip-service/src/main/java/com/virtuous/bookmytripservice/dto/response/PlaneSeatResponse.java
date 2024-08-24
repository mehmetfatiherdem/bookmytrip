package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneSeatResponse {
    private int number;
    private String letter;
}
