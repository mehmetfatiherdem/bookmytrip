package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTerminalConverter;
import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusTerminal;
import com.virtuous.bookmytripservice.repository.BusTerminalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusTerminalService {

    private final BusTerminalRepository busTerminalRepository;

    public BusTerminalResponse createBusTerminal(BusTerminalSaveRequest request) {
        BusTerminal busTerminal = new BusTerminal();

        busTerminal.setName(request.getName());
        busTerminal.setCity(request.getCity());
        busTerminal.setCountry(request.getCountry());

        busTerminalRepository.save(busTerminal);

        return BusTerminalConverter.toResponse(busTerminal);
    }

    public BusTerminal findBusTerminalById(UUID id) {

        Optional<BusTerminal> busTerminal = busTerminalRepository.findById(id);

        if (busTerminal.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.BUS_TERMINAL_NOT_FOUND);
        }

        return busTerminal.get();
    }
}
