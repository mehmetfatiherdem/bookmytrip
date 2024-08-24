package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusConverter;
import com.virtuous.bookmytripservice.dto.request.BusSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.Bus;
import com.virtuous.bookmytripservice.model.BusOperator;
import com.virtuous.bookmytripservice.repository.AdminBusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminBusService {

    private final AdminBusRepository adminBusRepository;

    public BusResponse createBus(BusSaveRequest request) {
        Bus bus = new Bus();
        bus.setBrand(request.getBrand());
        bus.setModel(request.getModel());

        adminBusRepository.save(bus);

        return BusConverter.toResponse(bus);
    }

    public Bus findBusById(Long id) {

        Optional<Bus> bus = adminBusRepository.findById(id);

        if (bus.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.BUS_NOT_FOUND);
        }

        return bus.get();
    }
}
