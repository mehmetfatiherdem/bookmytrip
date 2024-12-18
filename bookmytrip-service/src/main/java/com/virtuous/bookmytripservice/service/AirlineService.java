package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirlineConverter;
import com.virtuous.bookmytripservice.dto.request.AirlinePartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.AirlineSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Airline;
import com.virtuous.bookmytripservice.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineResponse partialUpdateAirlineByAirlineCode(String airlineCode, AirlinePartialUpdateRequest request) {
        var airline = findAirlineByCode(airlineCode);

        if(request.getCode().isPresent()) airline.setCode(request.getCode().get());
        if(request.getName().isPresent()) airline.setName(request.getName().get());

        airlineRepository.save(airline);
        return AirlineConverter.toResponse(airline);
    }

    public AirlineResponse updateAirlineByAirlineCode(String airlineCode, AirlineSaveRequest request) {
        var airline = findAirlineByCode(airlineCode);

        airline.setCode(request.getCode());
        airline.setName(request.getName());

        airlineRepository.save(airline);
        return AirlineConverter.toResponse(airline);
    }

    public List<AirlineResponse> getAllAirlines() {
        var airlines = airlineRepository.findAll();
        return AirlineConverter.toResponse(airlines);
    }

    public AirlineResponse getAirlineByCode(String airlineCode) {
        var airline = findAirlineByCode(airlineCode);
        return AirlineConverter.toResponse(airline);
    }

    public Airline findAirlineByCode(String code) {
        Optional<Airline> airline = airlineRepository.findAirlineByCode(code.toUpperCase());

        if (airline.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.AIRLINE_NOT_FOUND);
        }
        return airline.get();
    }

    public AirlineResponse createAirline(AirlineSaveRequest request) {
        Airline airline = new Airline();
        airline.setCode(request.getCode());
        airline.setName(request.getName());

        airlineRepository.save(airline);

        return AirlineConverter.toResponse(airline);
    }

}
