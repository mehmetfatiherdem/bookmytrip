package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTripConverter;
import com.virtuous.bookmytripservice.dto.request.BusTripSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTripResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusTrip;
import com.virtuous.bookmytripservice.model.enums.TripStatus;
import com.virtuous.bookmytripservice.repository.BusTripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BusTripService {

    private final BusTripRepository busTripRepository;

    private final BusTerminalService busTerminalService;
    private final BusOperatorService busOperatorService;
    private final BusService busService;

    public BusTripResponse getBusTripByTripNumber(String busTripNumber) {
        var busTrip = findBusTripByTripNumber(busTripNumber);
        return BusTripConverter.toResponse(busTrip);
    }

    public BusTripResponse createBusTrip(BusTripSaveRequest request) {

        var departureBusTerminal = busTerminalService.findBusTerminalById(request.getDepartureBusTerminalId());
        var arrivalBusTerminal = busTerminalService.findBusTerminalById(request.getArrivalBusTerminalId());
        var busOperator = busOperatorService.findBusOperatorById(request.getBusOperatorId());
        var bus = busService.findBusById(request.getBusId());

        BusTrip busTrip = new BusTrip();
        busTrip.setTripNumber(request.getTripNumber());
        busTrip.setDeparture(request.getDeparture());
        busTrip.setArrival(request.getArrival());
        busTrip.setDepartureTime(request.getDepartureTime());
        busTrip.setArrivalTime(request.getArrivalTime());
        busTrip.setDepartureBusTerminal(departureBusTerminal);
        busTrip.setArrivalBusTerminal(arrivalBusTerminal);
        busTrip.setBusOperator(busOperator);
        busTrip.setBus(bus);
        busTrip.setStatus(TripStatus.valueOf(request.getStatus().toUpperCase()));

        busTripRepository.save(busTrip);

        return BusTripConverter.toResponse(busTrip);

    }

    public List<BusTripResponse> getAllBusTrips() {

        var busTrips = busTripRepository.findAll();

        return BusTripConverter.toResponse(busTrips);
    }

    public BusTrip findBusTripByTripNumber(String tripNumber) {
        var busTrip = busTripRepository.findBusTripByTripNumber(tripNumber);
        if (busTrip.isEmpty()) throw new BookMyTripException(ExceptionMessages.BUS_TRIP_NOT_FOUND);
        return busTrip.get();
    }

    public BusTrip findBusTripById(UUID id) {
        var busTrip = busTripRepository.findById(id);
        if (busTrip.isEmpty()) throw new BookMyTripException(ExceptionMessages.BUS_TRIP_NOT_FOUND);
        return busTrip.get();
    }
}
