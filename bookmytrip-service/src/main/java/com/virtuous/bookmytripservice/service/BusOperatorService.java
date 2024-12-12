package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusOperatorConverter;
import com.virtuous.bookmytripservice.dto.request.BusOperatorPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.BusOperatorSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusOperatorResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.BusOperator;
import com.virtuous.bookmytripservice.repository.BusOperatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BusOperatorService {

    private final BusOperatorRepository busOperatorRepository;

    public BusOperatorResponse partialUpdateBusOperatorById(String busOperatorId, BusOperatorPartialUpdateRequest request) {
        var busOperator = findBusOperatorById(UUID.fromString(busOperatorId));

        if(request.getName().isPresent()) busOperator.setName(request.getName().get());

        busOperatorRepository.save(busOperator);
        return BusOperatorConverter.toResponse(busOperator);
    }

    public BusOperatorResponse updateAirlineByAirlineCode(String busOperatorId, BusOperatorSaveRequest request) {
        var busOperator = findBusOperatorById(UUID.fromString(busOperatorId));

        busOperator.setName(request.getName());

        busOperatorRepository.save(busOperator);
        return BusOperatorConverter.toResponse(busOperator);
    }

    public BusOperatorResponse getBusOperatorById(String busOperatorId) {
        var busOperator = findBusOperatorById(UUID.fromString(busOperatorId));
        return BusOperatorConverter.toResponse(busOperator);
    }

    public List<BusOperatorResponse> getAllBusOperators() {
        var busOperators = busOperatorRepository.findAll();
        return BusOperatorConverter.toResponse(busOperators);
    }

    public BusOperatorResponse createBusOperator(BusOperatorSaveRequest request) {
        BusOperator busOperator = new BusOperator();
        busOperator.setName(request.getName());

        busOperatorRepository.save(busOperator);

        return BusOperatorConverter.toResponse(busOperator);
    }

    public BusOperator findBusOperatorById(UUID id) {

        Optional<BusOperator> busOperator = busOperatorRepository.findById(id);

        if (busOperator.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.BUS_OPERATOR_NOT_FOUND);
        }

        return busOperator.get();
    }
}
