package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripResponse implements Serializable {
    private String id;
    private String departure;
    private String arrival;
    private String status;
    private ZonedDateTime departureTime;
    private ZonedDateTime arrivalTime;
}
