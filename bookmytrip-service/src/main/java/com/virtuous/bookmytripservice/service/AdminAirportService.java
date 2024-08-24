package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.AirportConverter;
import com.virtuous.bookmytripservice.dto.request.AirportSaveRequest;
import com.virtuous.bookmytripservice.dto.response.AirportResponse;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.repository.AdminAirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminAirportService {

    private final AdminAirportRepository adminAirportRepository;

    public AirportResponse createAirport(AirportSaveRequest request) {
        Airport airport = new Airport();
        airport.setCode(request.getCode());
        airport.setCity(request.getCity());
        airport.setCountry(request.getCountry());
        airport.setName(request.getName());

        adminAirportRepository.save(airport);

        return AirportConverter.toResponse(airport);
    }
}
