package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneTicketConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PlaneTicketSearchRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.model.Airline;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.PlaneTicket;
import com.virtuous.bookmytripservice.repository.PlaneTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaneTicketService {

    private final PlaneTicketRepository planeTicketRepository;

    private final PlaneService planeService;
    private final AirlineService airlineService;
    private final AirportService airportService;

    public PlaneTicketResponse createPlaneTicket(PlaneTicketSaveRequest request) {

        var departureAirport = airportService.getAirportByCode(request.getDepartureAirportCode());
        var arrivalAirport = airportService.getAirportByCode(request.getDepartureAirportCode());
        var airline = airlineService.getAirlineByCode(request.getAirlineCode());
        var plane = planeService.findPlaneById(request.getPlaneId());

        PlaneTicket planeTicket = new PlaneTicket();
        planeTicket.setFlightNumber(request.getFlightNumber());
        planeTicket.setDeparture(request.getDeparture());
        planeTicket.setArrival(request.getArrival());
        planeTicket.setDepartureTime(request.getDepartureTime());
        planeTicket.setArrivalTime(request.getArrivalTime());
        planeTicket.setPrice(request.getPrice());
        planeTicket.setDepartureAirport(departureAirport);
        planeTicket.setArrivalAirport(arrivalAirport);
        planeTicket.setAirline(airline);
        planeTicket.setPlane(plane);

        planeTicketRepository.save(planeTicket);

        return PlaneTicketConverter.toResponse(planeTicket);
    }

    public List<PlaneTicketResponse> getPlaneTickets() {
        return PlaneTicketConverter.toResponse(planeTicketRepository.findAll());
    }

    public List<PlaneTicketResponse> searchPlaneTickets(PlaneTicketSearchRequest planeTicketSearchRequest) {

        Airline airline = airlineService.getAirlineByCode(planeTicketSearchRequest.getAirlineCode());
        Airport departureAirport = airportService.getAirportByCode(planeTicketSearchRequest.getDepartureAirportCode());
        Airport arrivalAirport = airportService.getAirportByCode(planeTicketSearchRequest.getArrivalAirportCode());

        return PlaneTicketConverter.toResponse(planeTicketRepository.findPlaneTicketsByAirlineAndDepartureAirportAndArrivalAirportAndDepartureTime(airline, departureAirport, arrivalAirport, planeTicketSearchRequest.getDepartureTime()));
    }
}
