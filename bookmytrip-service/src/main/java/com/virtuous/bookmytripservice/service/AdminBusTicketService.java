package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTicketConverter;
import com.virtuous.bookmytripservice.dto.request.BusTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.model.Bus;
import com.virtuous.bookmytripservice.model.BusTicket;
import com.virtuous.bookmytripservice.repository.AdminBusTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminBusTicketService {

    private final AdminBusTicketRepository adminBusTicketRepository;

    private final AdminBusTerminalService adminBusTerminalService;
    private final AdminBusOperatorService adminBusOperatorService;
    private final AdminBusService adminBusService;

    public BusTicketResponse createBusTicket(BusTicketSaveRequest request) {

        var departureBusTerminal = adminBusTerminalService.findBusTerminalById(request.getDepartureBusTerminalId());
        var arrivalBusTerminal = adminBusTerminalService.findBusTerminalById(request.getArrivalBusTerminalId());
        var busOperator = adminBusOperatorService.findBusOperatorById(request.getBusOperatorId());
        var bus = adminBusService.findBusById(request.getBusId());

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

        adminBusTicketRepository.save(busTicket);

        return BusTicketConverter.toResponse(busTicket);

    }

    public List<BusTicketResponse> getAllBusTickets() {

        var busTickets = adminBusTicketRepository.findAll();

        return BusTicketConverter.toResponse(busTickets);
    }
}
