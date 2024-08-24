package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AirportSaveRequest {
    private String code;
    private String name;
    private String city;
    private String country;

}
