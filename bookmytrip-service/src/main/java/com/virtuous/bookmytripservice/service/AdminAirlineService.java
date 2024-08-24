package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirlineConverter;
import com.virtuous.bookmytripservice.dto.request.AirlineSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirlineResponse;
import com.virtuous.bookmytripservice.model.Airline;
import com.virtuous.bookmytripservice.repository.AdminAirlineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminAirlineService {

    private final AdminAirlineRepository adminAirlineRepository;

    public AirlineResponse createAirline(AirlineSaveRequest request) {
        Airline airline = new Airline();
        airline.setCode(request.getCode());
        airline.setName(request.getName());

        adminAirlineRepository.save(airline);

        return AirlineConverter.toResponse(airline);
    }
}
