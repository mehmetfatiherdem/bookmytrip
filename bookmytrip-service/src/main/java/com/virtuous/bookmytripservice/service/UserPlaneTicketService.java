package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneTicketConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneTicketSearchRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.model.Airline;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.repository.PlaneTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserPlaneTicketService {

    private final PlaneTicketRepository planeTicketRepository;

    private final AirlineService airlineService;
    private final AirportService airportService;

    public List<PlaneTicketResponse> getPlaneTickets() {
       return PlaneTicketConverter.toResponse(planeTicketRepository.findAll());
    }

    public List<PlaneTicketResponse> searchPlaneTickets(PlaneTicketSearchRequest planeTicketSearchRequest) {

        Airline airline = airlineService.getAirlineById(planeTicketSearchRequest.getAirlineId());
        Airport departureAirport = airportService.getAirportById(planeTicketSearchRequest.getDepartureAirportId());
        Airport arrivalAirport = airportService.getAirportById(planeTicketSearchRequest.getDepartureAirportId());

        return PlaneTicketConverter.toResponse(planeTicketRepository.findPlaneTicketsByAirlineAndDepartureAirportAndArrivalAirportAndDepartureTime(airline, departureAirport, arrivalAirport, planeTicketSearchRequest.getDepartureTime()));
    }
}
