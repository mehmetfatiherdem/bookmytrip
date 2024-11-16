package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTicketConverter;
import com.virtuous.bookmytripservice.dto.request.BusTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.model.BusTicket;
import com.virtuous.bookmytripservice.repository.BusTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BusTicketService {

    private final BusTicketRepository busTicketRepository;

    private final BusTerminalService busTerminalService;
    private final BusOperatorService busOperatorService;
    private final BusService busService;

    public BusTicketResponse createBusTicket(BusTicketSaveRequest request) {

        var departureBusTerminal = busTerminalService.findBusTerminalById(request.getDepartureBusTerminalId());
        var arrivalBusTerminal = busTerminalService.findBusTerminalById(request.getArrivalBusTerminalId());
        var busOperator = busOperatorService.findBusOperatorById(request.getBusOperatorId());
        var bus = busService.findBusById(request.getBusId());

        BusTicket busTicket = new BusTicket();
        busTicket.setTripNumber(request.getTripNumber());
        busTicket.setDeparture(request.getDeparture());
        busTicket.setArrival(request.getArrival());
        busTicket.setDepartureTime(request.getDepartureTime());
        busTicket.setArrivalTime(request.getArrivalTime());
        busTicket.setPrice(request.getPrice());
        busTicket.setDepartureBusTerminal(departureBusTerminal);
        busTicket.setArrivalBusTerminal(arrivalBusTerminal);
        busTicket.setBusOperator(busOperator);
        busTicket.setBus(bus);

        busTicketRepository.save(busTicket);

        return BusTicketConverter.toResponse(busTicket);

    }

    public List<BusTicketResponse> getAllBusTickets() {

        var busTickets = busTicketRepository.findAll();

        return BusTicketConverter.toResponse(busTickets);
    }
}
