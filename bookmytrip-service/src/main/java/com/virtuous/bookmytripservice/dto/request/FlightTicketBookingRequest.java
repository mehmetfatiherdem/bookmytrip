package com.virtuous.bookmytripservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightTicketBookingRequest {
    private String flightTicketId;
    private String passengerIdentificationNumber;
    private String passengerName;
    private String passengerLastName;
    private String passengerPhoneNumber;
    private String passengerGender;
    private Integer passengerAge;
}
