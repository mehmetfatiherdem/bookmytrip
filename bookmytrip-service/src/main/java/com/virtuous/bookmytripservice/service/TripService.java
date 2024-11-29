package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.TripConverter;
import com.virtuous.bookmytripservice.dto.request.TripStatusUpdateRequest;
import com.virtuous.bookmytripservice.dto.response.TripResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.enums.TripStatus;
import com.virtuous.bookmytripservice.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripService {

    private final TripRepository tripRepository;

    public TripResponse updateTripStatus(String tripId, TripStatusUpdateRequest request) {
        var tripFound = tripRepository.findById(UUID.fromString(tripId));

        if (tripFound.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.TRIP_NOT_FOUND);
        }

        var trip = tripFound.get();

        trip.setStatus(TripStatus.valueOf(request.getStatus().toUpperCase()));

        tripRepository.save(trip);

        return TripConverter.toResponse(trip);
    }

    public List<TripResponse> getAllTrips() {
        return TripConverter.toResponse(tripRepository.findAll());
    }

    public List<TripResponse> getTripsByDestinationAndArrival(String departure, String arrival) {
        var trips = tripRepository.findTripsByDepartureAndAndArrivalIgnoreCase(departure, arrival);
        return TripConverter.toResponse(trips);
    }
}
