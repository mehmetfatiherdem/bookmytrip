package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusTerminalConverter;
import com.virtuous.bookmytripservice.dto.request.BusTerminalSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusTerminalResponse;
import com.virtuous.bookmytripservice.model.BusTerminal;
import com.virtuous.bookmytripservice.repository.AdminBusTerminalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminBusTerminalService {

    private final AdminBusTerminalRepository adminBusTerminalRepository;

    public BusTerminalResponse createBusTerminal(BusTerminalSaveRequest request) {
        BusTerminal busTerminal = new BusTerminal();

        busTerminal.setName(request.getName());
        busTerminal.setCity(request.getCity());
        busTerminal.setCountry(request.getCountry());

        adminBusTerminalRepository.save(busTerminal);

        return BusTerminalConverter.toResponse(busTerminal);
    }
}
