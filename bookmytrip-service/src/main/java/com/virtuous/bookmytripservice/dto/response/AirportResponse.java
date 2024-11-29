package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportResponse implements Serializable {
    private String code;
    private String name;
    private String city;
    private String country;
    private String timeZone;
}
