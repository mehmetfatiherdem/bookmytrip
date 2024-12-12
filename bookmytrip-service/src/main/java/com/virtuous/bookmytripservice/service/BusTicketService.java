package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTicketConverter;
import com.virtuous.bookmytripservice.dto.request.BusTicketBookingRequest;
import com.virtuous.bookmytripservice.dto.request.BusTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PassengerSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTicketResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusTicket;
import com.virtuous.bookmytripservice.model.Passenger;
import com.virtuous.bookmytripservice.model.enums.TicketStatus;
import com.virtuous.bookmytripservice.repository.BusTicketRepository;
import com.virtuous.bookmytripservice.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class BusTicketService {

    private final JwtUtil jwtUtil;

    private final BusTicketRepository busTicketRepository;

    private final BusSeatService busSeatService;
    private final TripService tripService;
    private final PassengerService passengerService;

    public BusTicketResponse getBusTicketById(String id) {
        var busTicket = findBusTicketById(UUID.fromString(id));
        return BusTicketConverter.toResponse(busTicket);
    }

    public List<BusTicketResponse> getAllBusTickets() {
        var busTickets = busTicketRepository.findAll();
        return BusTicketConverter.toResponse(busTickets);
    }

    public BusTicketResponse createBusTicket(BusTicketSaveRequest request) {

        var busSeat = busSeatService.findBusSeatById(UUID.fromString(request.getBusSeatId()));
        var trip = tripService.findTripById(UUID.fromString(request.getTripId()));

        BusTicket busTicket = new BusTicket();
        busTicket.setStatus(TicketStatus.valueOf(request.getTicketStatus()));
        busTicket.setPrice(request.getPrice());
        busTicket.setBusSeat(busSeat);
        busTicket.setTrip(trip);

        busTicketRepository.save(busTicket);

        return BusTicketConverter.toResponse(busTicket);
    }

    @Transactional
    public List<BusTicketResponse> bookBusTickets(List<BusTicketBookingRequest> requests) {

        List<BusTicket> busTickets = new ArrayList<>();

        for (BusTicketBookingRequest request: requests) {
            String userId = jwtUtil.extractUserId(jwtUtil.extractJwtFromHeader());
            BusTicket busTicket = findBusTicketById(UUID.fromString(request.getBusTicketId()));

            if (!(busTicket.getStatus() == TicketStatus.AVAILABLE)) throw new BookMyTripException(ExceptionMessages.TICKET_ALREADY_BOOKED);

            busTicket.setStatus(TicketStatus.ON_HOLD);
            busTicketRepository.save(busTicket);

            Passenger passenger = passengerService.createAndSavePassengerInstance(new PassengerSaveRequest(request.getPassengerIdentificationNumber(), request.getPassengerName(), request.getPassengerLastName(), request.getPassengerPhoneNumber(), request.getPassengerGender(), request.getPassengerAge()));
            busTicket.setUserId(UUID.fromString(userId));
            busTicket.setPassenger(passenger);
            busTicket.setStatus(TicketStatus.BOOKED);
            passengerService.addTicketToPassenger(passenger, busTicket);

            busTickets.add(busTicket);

            busTicketRepository.save(busTicket);
        }

        return BusTicketConverter.toResponse(busTickets);
    }

    public BusTicket findBusTicketById(UUID busTicketId) {
        var busTicket = busTicketRepository.findById(busTicketId);
        if (busTicket.isEmpty()) throw new BookMyTripException(ExceptionMessages.BUS_TICKET_NOT_FOUND);
        return busTicket.get();
    }


}
