package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusTicketBookingRequest {
    private String busTicketId;
    private String passengerIdentificationNumber;
    private String passengerName;
    private String passengerLastName;
    private String passengerPhoneNumber;
    private String passengerGender;
    private Integer passengerAge;
}
