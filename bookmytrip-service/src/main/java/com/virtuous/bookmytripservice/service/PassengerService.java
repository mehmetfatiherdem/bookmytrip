package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PassengerConverter;
import com.virtuous.bookmytripservice.dto.request.PassengerSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PassengerResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Passenger;
import com.virtuous.bookmytripservice.model.Ticket;
import com.virtuous.bookmytripservice.model.enums.Gender;
import com.virtuous.bookmytripservice.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerResponse createPassenger(PassengerSaveRequest request) {
        return PassengerConverter.toResponse(createAndSavePassengerInstance(request));
    }

    public Passenger createAndSavePassengerInstance(PassengerSaveRequest request) {
        Passenger passenger = new Passenger();
        passenger.setIdentificationNumber(request.getIdentificationNumber());
        passenger.setAge(request.getAge());
        passenger.setGender(Gender.valueOf(request.getGender()));
        passenger.setName(request.getName());
        passenger.setLastName(request.getLastName());
        passenger.setPhoneNumber(request.getPhoneNumber());

        passengerRepository.save(passenger);

        return passenger;
    }

    public Passenger getPassengerById(String id) {
        var passengerFound = passengerRepository.findById(UUID.fromString(id));
        if (passengerFound.isEmpty()) throw new BookMyTripException(ExceptionMessages.PASSENGER_NOT_FOUND);
        return passengerFound.get();
    }

    public void addTicketToPassenger(Passenger passenger, Ticket ticket) {
        passenger.setTicket(ticket);
        passengerRepository.save(passenger);
    }
}
