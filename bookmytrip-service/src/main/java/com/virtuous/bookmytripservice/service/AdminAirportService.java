package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirportConverter;
import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminAirportService {

    private final AirportRepository airportRepository;

    public AirportResponse createAirport(AirportSaveRequest request) {
        Airport airport = new Airport();
        airport.setCode(request.getCode());
        airport.setCity(request.getCity());
        airport.setCountry(request.getCountry());
        airport.setName(request.getName());

        airportRepository.save(airport);

        return AirportConverter.toResponse(airport);
    }

    public Airport findAirportById(UUID id) {
        Optional<Airport> airport = airportRepository.findById(id);

        if (airport.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.AIRPORT_NOT_FOUND);
        }

        return airport.get();
    }

}
