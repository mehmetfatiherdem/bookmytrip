package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.FlightTicketConverter;
import com.virtuous.bookmytripservice.dto.request.*;
import com.virtuous.bookmytripservice.dto.response.FlightTicketResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.FlightTicket;
import com.virtuous.bookmytripservice.model.Passenger;
import com.virtuous.bookmytripservice.model.enums.TicketStatus;
import com.virtuous.bookmytripservice.repository.FlightTicketRepository;
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
public class FlightTicketService {

    private final JwtUtil jwtUtil;

    private final FlightTicketRepository flightTicketRepository;

    private final PlaneSeatService planeSeatService;
    private final TripService tripService;
    private final PassengerService passengerService;


    public FlightTicketResponse partialUpdateFlightTicketByFlightTicketId(String flightTicketId, FlightTicketPartialUpdateRequest request) {
        var flightTicket = findFlightTicketById(UUID.fromString(flightTicketId));

        if(request.getTicketStatus().isPresent()) flightTicket.setStatus(TicketStatus.valueOf(request.getTicketStatus().get()));
        if(request.getPrice().isPresent()) flightTicket.setPrice(request.getPrice().get());
        if(request.getPlaneSeatId().isPresent()) {
            var planeSeat = planeSeatService.findPlaneSeatById(UUID.fromString(request.getPlaneSeatId().get()));
            flightTicket.setPlaneSeat(planeSeat);
        }
        if(request.getTripId().isPresent()) {
            var trip = tripService.findTripById(UUID.fromString(request.getTripId().get()));
            flightTicket.setTrip(trip);
        }

        flightTicketRepository.save(flightTicket);
        return FlightTicketConverter.toResponse(flightTicket);
    }

    public FlightTicketResponse updateFlightTicketByFlightTicketId(String flightTicketId, FlightTicketSaveRequest request) {
        var flightTicket = findFlightTicketById(UUID.fromString(flightTicketId));
        var planeSeat = planeSeatService.findPlaneSeatById(UUID.fromString(request.getPlaneSeatId()));
        var trip = tripService.findTripById(UUID.fromString(request.getTripId()));

        flightTicket.setStatus(TicketStatus.valueOf(request.getTicketStatus()));
        flightTicket.setPrice(request.getPrice());
        flightTicket.setPlaneSeat(planeSeat);
        flightTicket.setTrip(trip);

        flightTicketRepository.save(flightTicket);
        return FlightTicketConverter.toResponse(flightTicket);
    }

    public List<FlightTicketResponse> getAllFlightTickets() {
        var flightTickets = flightTicketRepository.findAll();
        return FlightTicketConverter.toResponse(flightTickets);
    }

    public FlightTicketResponse getFlightTicketById(String flightTicketId) {
        var flightTicket = findFlightTicketById(UUID.fromString(flightTicketId));
        return FlightTicketConverter.toResponse(flightTicket);
    }

    public FlightTicketResponse createFlightTicket(FlightTicketSaveRequest request) {

        var planeSeat = planeSeatService.findPlaneSeatById(UUID.fromString(request.getPlaneSeatId()));
        var trip = tripService.findTripById(UUID.fromString(request.getTripId()));

        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setStatus(TicketStatus.valueOf(request.getTicketStatus()));
        flightTicket.setPrice(request.getPrice());
        flightTicket.setPlaneSeat(planeSeat);
        flightTicket.setTrip(trip);

        flightTicketRepository.save(flightTicket);

        return FlightTicketConverter.toResponse(flightTicket);
    }

    @Transactional
    public FlightTicketResponse bookFlightTicket(String flightTicketId, PassengerSaveRequest passengerSaveRequest) {

        String userId = jwtUtil.extractUserId(jwtUtil.extractJwtFromHeader());
        FlightTicket flightTicket = findFlightTicketById(UUID.fromString(flightTicketId));

        if (!(flightTicket.getStatus() == TicketStatus.AVAILABLE)) throw new BookMyTripException(ExceptionMessages.TICKET_ALREADY_BOOKED);

        flightTicket.setStatus(TicketStatus.ON_HOLD);
        flightTicketRepository.save(flightTicket);

        Passenger passenger = passengerService.createAndSavePassengerInstance(passengerSaveRequest);

        flightTicket.setUserId(UUID.fromString(userId));
        flightTicket.setPassenger(passenger);
        flightTicket.setStatus(TicketStatus.BOOKED);
        passengerService.addTicketToPassenger(passenger, flightTicket);

        flightTicketRepository.save(flightTicket);

        return FlightTicketConverter.toResponse(flightTicket);
    }

    @Transactional
    public List<FlightTicketResponse> bookFlightTickets(List<FlightTicketBookingRequest> requests) {

        List<FlightTicket> flightTickets = new ArrayList<>();

        for (FlightTicketBookingRequest request: requests) {
            String userId = jwtUtil.extractUserId(jwtUtil.extractJwtFromHeader());
            FlightTicket flightTicket = findFlightTicketById(UUID.fromString(request.getFlightTicketId()));

            if (!(flightTicket.getStatus() == TicketStatus.AVAILABLE)) throw new BookMyTripException(ExceptionMessages.TICKET_ALREADY_BOOKED);

            flightTicket.setStatus(TicketStatus.ON_HOLD);
            flightTicketRepository.save(flightTicket);

            Passenger passenger = passengerService.createAndSavePassengerInstance(new PassengerSaveRequest(request.getPassengerIdentificationNumber(), request.getPassengerName(), request.getPassengerLastName(), request.getPassengerPhoneNumber(), request.getPassengerGender(), request.getPassengerAge()));
            flightTicket.setUserId(UUID.fromString(userId));
            flightTicket.setPassenger(passenger);
            flightTicket.setStatus(TicketStatus.BOOKED);
            passengerService.addTicketToPassenger(passenger, flightTicket);

            flightTickets.add(flightTicket);

            flightTicketRepository.save(flightTicket);
        }

        return FlightTicketConverter.toResponse(flightTickets);
    }

    public FlightTicket findFlightTicketById(UUID flightTicketId) {
        var ticket = flightTicketRepository.findById(flightTicketId);
        if (ticket.isEmpty()) throw new BookMyTripException(ExceptionMessages.FLIGHT_TICKET_NOT_FOUND);
        return ticket.get();
    }

}
