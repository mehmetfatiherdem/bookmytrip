package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.FlightConverter;
import com.virtuous.bookmytripservice.dto.request.FlightSaveRequest;
import com.virtuous.bookmytripservice.dto.response.FlightResponse;
import com.virtuous.bookmytripservice.model.Airport;
import com.virtuous.bookmytripservice.model.Flight;
import com.virtuous.bookmytripservice.model.enums.TripStatus;
import com.virtuous.bookmytripservice.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final PlaneService planeService;
    private final AirlineService airlineService;
    private final AirportService airportService;

    public FlightResponse createFlight(FlightSaveRequest request) {

        var departureAirport = airportService.getAirportByCode(request.getDepartureAirportCode().toUpperCase());
        var arrivalAirport = airportService.getAirportByCode(request.getArrivalAirportCode().toUpperCase());
        var airline = airlineService.getAirlineByCode(request.getAirlineCode().toUpperCase());
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

        Airport departureAirport = airportService.getAirportByCode(departureAirportCode.toUpperCase());
        Airport arrivalAirport = airportService.getAirportByCode(arrivalAirportCode.toUpperCase());

        return FlightConverter.toResponse(flightRepository.findFlightsByAndDepartureAirportAndArrivalAirportAndDepartureTimeDate(departureAirport, arrivalAirport, date));
    }
}
