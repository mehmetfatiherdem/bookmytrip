package com.virtuous.bookmytripservice.converter;

import com.virtuous.bookmytripservice.dto.response.PassengerResponse;
import com.virtuous.bookmytripservice.model.Passenger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PassengerConverter {

    public static PassengerResponse toResponse(Passenger passenger) {
        return PassengerResponse.builder()
                .identificationNumber(passenger.getIdentificationNumber())
                .age(passenger.getAge())
                .gender(passenger.getGender())
                .name(passenger.getName())
                .lastName(passenger.getLastName())
                .phoneNumber(passenger.getPhoneNumber())
                .build();
    }

    public static List<PassengerResponse> toResponse(List<Passenger> passengers) {
        return passengers
                .stream()
                .map(PassengerConverter::toResponse)
                .toList();
    }
}
