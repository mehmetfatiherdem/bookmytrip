package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirportConverter;
import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.enums.TimeZoneEnum;
import com.virtuous.bookmytripservice.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public List<AirportResponse> getAllAirports() {
        var airports = airportRepository.findAll();
        return AirportConverter.toResponse(airports);
    }

    public AirportResponse getAirportByCode(String airportCode) {
        var airport = findAirportByCode(airportCode.toUpperCase());
        return AirportConverter.toResponse(airport);
    }

    public Airport findAirportByCode(String code) {
        Optional<Airport> airport = airportRepository.findAirportByCode(code);

        if(airport.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.AIRPORT_NOT_FOUND);
        }

        return  airport.get();
    }

    public AirportResponse createAirport(AirportSaveRequest request) {
        Airport airport = new Airport();
        airport.setCode(request.getCode());
        airport.setCity(request.getCity());
        airport.setCountry(request.getCountry());
        airport.setName(request.getName());
        airport.setTimezone(TimeZoneEnum.fromString(request.getTimeZone()));

        airportRepository.save(airport);

        return AirportConverter.toResponse(airport);
    }

}
