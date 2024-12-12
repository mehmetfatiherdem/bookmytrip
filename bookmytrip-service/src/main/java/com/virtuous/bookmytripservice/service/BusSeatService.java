package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusSeatConverter;
import com.virtuous.bookmytripservice.dto.request.BusSeatPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusSeatResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusSeat;
import com.virtuous.bookmytripservice.repository.BusSeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BusSeatService {

    private final BusSeatRepository busSeatRepository;

    public BusSeatResponse partialUpdateBusSeatById(String id, BusSeatPartialUpdateRequest request) {
        var seat = findBusSeatById(UUID.fromString(id));
        if (request.getNumber().isPresent()) seat.setNumber(request.getNumber().get());
        busSeatRepository.save(seat);
        return BusSeatConverter.toResponse(seat);
    }

    public BusSeatResponse updateBusSeatById(String busSeatId, BusSeatSaveRequest request) {
        var seat = findBusSeatById(UUID.fromString(busSeatId));

        seat.setNumber(request.getNumber());
        busSeatRepository.save(seat);
        return BusSeatConverter.toResponse(seat);
    }

    public BusSeatResponse createBusSeat(BusSeatSaveRequest request) {
        BusSeat busSeat = new BusSeat();
        busSeat.setNumber(request.getNumber());

        busSeatRepository.save(busSeat);

        return BusSeatConverter.toResponse(busSeat);
    }

    public BusSeat findBusSeatById(UUID busSeatId) {
        var busSeat = busSeatRepository.findById(busSeatId);

        if (busSeat.isEmpty()) throw new BookMyTripException(ExceptionMessages.BUS_SEAT_NOT_FOUND);

        return busSeat.get();
    }

}
