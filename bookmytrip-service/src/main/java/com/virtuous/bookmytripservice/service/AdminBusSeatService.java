package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.BusSeatConverter;
import com.virtuous.bookmytripservice.dto.request.BusSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.BusSeatResponse;
import com.virtuous.bookmytripservice.model.BusSeat;
import com.virtuous.bookmytripservice.repository.AdminBusSeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminBusSeatService {

    private final AdminBusSeatRepository adminBusSeatRepository;

    public BusSeatResponse createBusSeat(BusSeatSaveRequest request) {
        BusSeat busSeat = new BusSeat();
        busSeat.setNumber(request.getNumber());

        adminBusSeatRepository.save(busSeat);

        return BusSeatConverter.toResponse(busSeat);
    }

}
