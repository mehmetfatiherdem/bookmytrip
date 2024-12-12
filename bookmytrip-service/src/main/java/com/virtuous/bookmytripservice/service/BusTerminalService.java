package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTerminalConverter;
import com.virtuous.bookmytripservice.dto.request.BusTerminalPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusTerminal;
import com.virtuous.bookmytripservice.model.enums.TimeZoneEnum;
import com.virtuous.bookmytripservice.repository.BusTerminalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusTerminalService {

    private final BusTerminalRepository busTerminalRepository;

    public BusTerminalResponse partialUpdateBusTerminalById(String busTerminalId, BusTerminalPartialUpdateRequest request) {
        var terminal = findBusTerminalById(UUID.fromString(busTerminalId));
        if(request.getName().isPresent()) terminal.setName(request.getName().get());
        if(request.getCountry().isPresent()) terminal.setCountry(request.getCountry().get());
        if(request.getCity().isPresent()) terminal.setCity(request.getCity().get());
        if(request.getTimeZone().isPresent()) terminal.setTimezone(TimeZoneEnum.fromString(request.getTimeZone().get()));
        busTerminalRepository.save(terminal);
        return BusTerminalConverter.toResponse(terminal);
    }

    public BusTerminalResponse updateBusTerminalById(String busTerminalId, BusTerminalSaveRequest request) {
        var terminal = findBusTerminalById(UUID.fromString(busTerminalId));
        terminal.setName(request.getName());
        terminal.setCountry(request.getCountry());
        terminal.setCity(request.getCity());
        terminal.setTimezone(TimeZoneEnum.fromString(request.getTimeZone()));
        busTerminalRepository.save(terminal);
        return BusTerminalConverter.toResponse(terminal);
    }

    public BusTerminalResponse getBusTerminalById(String id) {
        var busTerminal = findBusTerminalById(UUID.fromString(id));
        return BusTerminalConverter.toResponse(busTerminal);
    }

    public List<BusTerminalResponse> getAllBusTerminals() {
        var busTerminals = busTerminalRepository.findAll();
        return BusTerminalConverter.toResponse(busTerminals);
    }

    public BusTerminalResponse createBusTerminal(BusTerminalSaveRequest request) {
        BusTerminal busTerminal = new BusTerminal();

        busTerminal.setName(request.getName());
        busTerminal.setCity(request.getCity());
        busTerminal.setCountry(request.getCountry());
        busTerminal.setTimezone(TimeZoneEnum.fromString(request.getTimeZone()));

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
