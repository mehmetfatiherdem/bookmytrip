package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusConverter;
import com.virtuous.bookmytripservice.dto.request.BusSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Bus;
import com.virtuous.bookmytripservice.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    public BusResponse getBusById(String id) {
        var bus = findBusById(UUID.fromString(id));
        return BusConverter.toResponse(bus);
    }

    public List<BusResponse> getAllBusses() {
        var busses = busRepository.findAll();
        return BusConverter.toResponse(busses);
    }

    public BusResponse createBus(BusSaveRequest request) {
        Bus bus = new Bus();
        bus.setBrand(request.getBrand());
        bus.setModel(request.getModel());

        busRepository.save(bus);

        return BusConverter.toResponse(bus);
    }

    public Bus findBusById(UUID id) {

        Optional<Bus> bus = busRepository.findById(id);

        if (bus.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.BUS_NOT_FOUND);
        }

        return bus.get();
    }
}
