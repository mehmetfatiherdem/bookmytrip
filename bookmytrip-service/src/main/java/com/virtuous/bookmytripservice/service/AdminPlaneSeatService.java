package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneSeatConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneSeatResponse;
import com.virtuous.bookmytripservice.model.PlaneSeat;
import com.virtuous.bookmytripservice.model.enums.Letter;
import com.virtuous.bookmytripservice.repository.PlaneSeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminPlaneSeatService {

    private final PlaneSeatRepository planeSeatRepository;

    public PlaneSeatResponse createPlaneSeat(PlaneSeatSaveRequest request) {
        PlaneSeat planeSeat = new PlaneSeat();
        planeSeat.setNumber(request.getNumber());
        planeSeat.setLetter(Letter.valueOf(request.getLetter()));

        planeSeatRepository.save(planeSeat);

        return PlaneSeatConverter.toResponse(planeSeat);
    }
}
