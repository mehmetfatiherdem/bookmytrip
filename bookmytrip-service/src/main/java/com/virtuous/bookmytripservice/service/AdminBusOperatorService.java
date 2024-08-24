package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusOperatorConverter;
import com.virtuous.bookmytripservice.dto.request.BusOperatorSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusOperator;
import com.virtuous.bookmytripservice.model.BusTerminal;
import com.virtuous.bookmytripservice.repository.AdminBusOperatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminBusOperatorService {

    private final AdminBusOperatorRepository adminBusOperatorRepository;

    public BusOperatorResponse createBusOperator(BusOperatorSaveRequest request) {
        BusOperator busOperator = new BusOperator();
        busOperator.setName(request.getName());

        adminBusOperatorRepository.save(busOperator);

        return BusOperatorConverter.toResponse(busOperator);
    }

    public BusOperator findBusOperatorById(Long id) {

        Optional<BusOperator> busOperator = adminBusOperatorRepository.findById(id);

        if (busOperator.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.BUS_OPERATOR_NOT_FOUND);
        }

        return busOperator.get();
    }
}
