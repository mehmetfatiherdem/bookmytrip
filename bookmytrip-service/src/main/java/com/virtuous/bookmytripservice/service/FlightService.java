package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.FlightConverter;
import com.virtuous.bookmytripservice.dto.request.FlightPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.FlightSaveRequest;
import com.virtuous.bookmytripservice.dto.response.FlightResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.Flight;
import com.virtuous.bookmytripservice.model.enums.TripStatus;
import com.virtuous.bookmytripservice.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final PlaneService planeService;
    private final AirlineService airlineService;
    private final AirportService airportService;

    public FlightResponse partialUpdateFlightByFlightNumber(String flightNumber, FlightPartialUpdateRequest request) {

        var flight = findFlightByFlightNumber(flightNumber);

        if(request.getFlightNumber().isPresent()) flight.setFlightNumber(request.getFlightNumber().get());
        if(request.getDeparture().isPresent())  flight.setDeparture(request.getDeparture().get());
        if(request.getArrival().isPresent()) flight.setArrival(request.getArrival().get());
        if (request.getDepartureTime().isPresent()) flight.setDepartureTime(request.getDepartureTime().get());
        if (request.getArrivalTime().isPresent()) flight.setArrivalTime(request.getArrivalTime().get());
        if (request.getDepartureAirportCode().isPresent()) {
            var departureAirport = airportService.findAirportByCode(request.getDepartureAirportCode().get().toUpperCase());
            flight.setDepartureAirport(departureAirport);
        }
        if (request.getArrivalAirportCode().isPresent()) {
            var arrivalAirport = airportService.findAirportByCode(request.getArrivalAirportCode().get().toUpperCase());
            flight.setArrivalAirport(arrivalAirport);
        }
        if (request.getAirlineCode().isPresent()) {
            var airline = airlineService.findAirlineByCode(request.getAirlineCode().get().toUpperCase());
            flight.setAirline(airline);
        }
        if (request.getPlaneId().isPresent()) {
            var plane = planeService.findPlaneById(UUID.fromString(request.getPlaneId().get()));
            flight.setPlane(plane);
        }

        if(request.getStatus().isPresent()) flight.setStatus(TripStatus.valueOf(request.getStatus().get()));

        flightRepository.save(flight);
        return FlightConverter.toResponse(flight);
    }

    public FlightResponse updateFlightByFlightNumber(String flightNumber, FlightSaveRequest request) {
        var departureAirport = airportService.findAirportByCode(request.getDepartureAirportCode().toUpperCase());
        var arrivalAirport = airportService.findAirportByCode(request.getArrivalAirportCode().toUpperCase());
        var airline = airlineService.findAirlineByCode(request.getAirlineCode().toUpperCase());
        var plane = planeService.findPlaneById(request.getPlaneId());
        var flight = findFlightByFlightNumber(flightNumber);

        flight.setFlightNumber(request.getFlightNumber());
        flight.setDeparture(request.getDeparture());
        flight.setArrival(request.getArrival());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setAirline(airline);
        flight.setPlane(plane);
        flight.setStatus(TripStatus.valueOf(request.getStatus()));

        flightRepository.save(flight);

        return FlightConverter.toResponse(flight);

    }

    public FlightResponse getFlightByFlightNumber(String flightNumber) {
        var flight = findFlightByFlightNumber(flightNumber);
        return FlightConverter.toResponse(flight);
    }

    public List<FlightResponse> getAllFlights() {
        var flights = flightRepository.findAll();
        return FlightConverter.toResponse(flights);
    }

    public FlightResponse createFlight(FlightSaveRequest request) {

        var departureAirport = airportService.findAirportByCode(request.getDepartureAirportCode().toUpperCase());
        var arrivalAirport = airportService.findAirportByCode(request.getArrivalAirportCode().toUpperCase());
        var airline = airlineService.findAirlineByCode(request.getAirlineCode().toUpperCase());
        var plane = planeService.findPlaneById(request.getPlaneId());

        Flight flight = new Flight();
        flight.setFlightNumber(request.getFlightNumber());
        flight.setDeparture(request.getDeparture());
        flight.setArrival(request.getArrival());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setAirline(airline);
        flight.setPlane(plane);
        flight.setStatus(TripStatus.valueOf(request.getStatus()));

        flightRepository.save(flight);

        return FlightConverter.toResponse(flight);
    }

    public List<FlightResponse> searchFlights(String departureAirportCode, String arrivalAirportCode, LocalDate date) {

        Airport departureAirport = airportService.findAirportByCode(departureAirportCode.toUpperCase());
        Airport arrivalAirport = airportService.findAirportByCode(arrivalAirportCode.toUpperCase());

        ZoneId departureZoneId = departureAirport.getTimezone().toZoneId();
        ZonedDateTime departureDateTime = date.atStartOfDay(departureZoneId);

        return FlightConverter.toResponse(flightRepository.findFlightsByDepartureAirportAndArrivalAirportAndDepartureTimeDate(departureAirport, arrivalAirport, departureDateTime));
    }

    public Flight findFlightByFlightNumber(String flightNumber) {
        var flight = flightRepository.findFlightByFlightNumber(flightNumber);
        if (flight.isEmpty()) throw new BookMyTripException(ExceptionMessages.FLIGHT_NOT_FOUND);
        return flight.get();
    }
}
