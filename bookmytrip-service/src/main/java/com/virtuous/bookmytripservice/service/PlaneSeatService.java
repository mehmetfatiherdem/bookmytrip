package com.virtuous.bookmytripservice.service;

import com.virtuous.bookmytripservice.converter.PlaneSeatConverter;
import com.virtuous.bookmytripservice.dto.request.PlaneSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.PlaneSeatResponse;
import com.virtuous.bookmytripservice.exception.BookMyTripException;
import com.virtuous.bookmytripservice.exception.ExceptionMessages;
import com.virtuous.bookmytripservice.model.PlaneSeat;
import com.virtuous.bookmytripservice.model.enums.Letter;
import com.virtuous.bookmytripservice.model.enums.PlaneSeatClass;
import com.virtuous.bookmytripservice.repository.PlaneSeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaneSeatService {

    private final PlaneSeatRepository planeSeatRepository;

    public PlaneSeatResponse getPlaneSeatById(String planeSeatId) {
        var planeSeat = findPlaneSeatById(UUID.fromString(planeSeatId));
        return PlaneSeatConverter.toResponse(planeSeat);
    }

    public List<PlaneSeatResponse> getAllPlaneSeats() {
        var planeSeats = planeSeatRepository.findAll();
        return PlaneSeatConverter.toResponse(planeSeats);
    }

    public PlaneSeatResponse createPlaneSeat(PlaneSeatSaveRequest request) {
        PlaneSeat planeSeat = new PlaneSeat();
        planeSeat.setNumber(request.getNumber());
        planeSeat.setLetter(Letter.valueOf(request.getLetter()));
        planeSeat.setPlaneSeatClass(PlaneSeatClass.valueOf(request.getPlaneSeatClass()));

        planeSeatRepository.save(planeSeat);

        return PlaneSeatConverter.toResponse(planeSeat);
    }

    public PlaneSeat findPlaneSeatById(UUID id) {
        var seatFound = planeSeatRepository.findById(id);

        if (seatFound.isEmpty()) throw new BookMyTripException(ExceptionMessages.PLANE_SEAT_NOT_FOUND);

        return seatFound.get();
     }
}
