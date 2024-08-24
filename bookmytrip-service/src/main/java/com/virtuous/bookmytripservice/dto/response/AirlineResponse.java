package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineResponse implements Serializable {
    private String code;
    private String name;
}
