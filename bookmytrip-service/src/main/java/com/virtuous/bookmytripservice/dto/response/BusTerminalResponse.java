package com.virtuous.bookmytripservice.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusTerminalResponse implements Serializable {
    private String name;
    private String city;
    private String country;
}
