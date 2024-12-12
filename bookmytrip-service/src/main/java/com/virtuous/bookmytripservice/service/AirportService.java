package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirportConverter;
import com.virtuous.bookmytripservice.dto.request.AirportPartialUpdateRequest;
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

    public AirportResponse partialUpdateAirportByAirportCode(String airportCode, AirportPartialUpdateRequest request) {
        var airport = findAirportByCode(airportCode);

        if(request.getCode().isPresent()) airport.setCode(request.getCode().get());
        if(request.getName().isPresent()) airport.setName(request.getName().get());
        if(request.getCity().isPresent()) airport.setCity(request.getCity().get());
        if(request.getCountry().isPresent()) airport.setCountry(request.getCountry().get());
        if(request.getTimeZone().isPresent()) airport.setTimezone(TimeZoneEnum.fromString(request.getTimeZone().get()));

        airportRepository.save(airport);
        return AirportConverter.toResponse(airport);
    }

    public AirportResponse updateAirlineByAirlineCode(String airportCode, AirportSaveRequest request) {
        var airport = findAirportByCode(airportCode);

        airport.setCode(request.getCode());
        airport.setName(request.getName());
        airport.setCity(request.getCity());
        airport.setCountry(request.getCountry());
        airport.setTimezone(TimeZoneEnum.fromString(request.getTimeZone()));

        airportRepository.save(airport);
        return AirportConverter.toResponse(airport);
    }

    public List<AirportResponse> getAllAirports() {
        var airports = airportRepository.findAll();
        return AirportConverter.toResponse(airports);
    }

    public AirportResponse getAirportByCode(String airportCode) {
        var airport = findAirportByCode(airportCode);
        return AirportConverter.toResponse(airport);
    }

    public Airport findAirportByCode(String code) {
        Optional<Airport> airport = airportRepository.findAirportByCode(code.toUpperCase());

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
