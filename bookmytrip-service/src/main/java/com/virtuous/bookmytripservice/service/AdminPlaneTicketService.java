package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneTicketConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.model.PlaneTicket;
import com.virtuous.bookmytripservice.repository.PlaneTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminPlaneTicketService {

    private final PlaneTicketRepository planeTicketRepository;

    private final AdminAirportService adminAirportService;
    private final AdminAirlineService adminAirlineService;
    private final AdminPlaneService adminPlaneService;

    public PlaneTicketResponse createPlaneTicket(PlaneTicketSaveRequest request) {

        var departureAirport = adminAirportService.findAirportById(request.getDepartureAirportId());
        var arrivalAirport = adminAirportService.findAirportById(request.getArrivalAirportId());
        var airline = adminAirlineService.findAirlineById(request.getAirlineId());
        var plane = adminPlaneService.findPlaneById(request.getPlaneId());

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
}
