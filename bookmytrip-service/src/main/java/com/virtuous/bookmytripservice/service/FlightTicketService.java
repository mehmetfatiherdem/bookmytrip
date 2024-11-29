package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.FlightTicketConverter;
import com.virtuous.bookmytripservice.dto.request.FlightTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.request.PassengerSaveRequest;
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

    public FlightTicketResponse createFlightTicket(FlightTicketSaveRequest request) {

        var planeSeat = planeSeatService.getPlaneSeatById(request.getPlaneSeatId());
        var trip = tripService.getTripById(request.getTripId());

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
        FlightTicket flightTicket = getFlightTicketById(flightTicketId);
        Passenger passenger = passengerService.createAndSavePassengerInstance(passengerSaveRequest);

        flightTicket.setUserId(UUID.fromString(userId));
        flightTicket.setPassenger(passenger);
        passengerService.addTicketToPassenger(passenger, flightTicket);

        flightTicketRepository.save(flightTicket);

        return FlightTicketConverter.toResponse(flightTicket);
    }

    public FlightTicket getFlightTicketById(String flightTicketId) {
        var ticket = flightTicketRepository.findById(UUID.fromString(flightTicketId));
        if (ticket.isEmpty()) throw new BookMyTripException(ExceptionMessages.FLIGHT_TICKET_NOT_FOUND);
        return ticket.get();
    }

}
