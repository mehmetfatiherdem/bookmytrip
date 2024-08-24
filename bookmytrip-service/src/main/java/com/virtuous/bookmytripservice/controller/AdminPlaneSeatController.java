package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneSeatResponse;
import com.virtuous.bookmytripservice.service.AdminPlaneSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/plane-seat")
@RequiredArgsConstructor
public class AdminPlaneSeatController {

    private final AdminPlaneSeatService adminPlaneSeatService;

    @PostMapping
    public GenericResponse<PlaneSeatResponse> createPlaneSeat(@RequestBody PlaneSeatSaveRequest request) {
        return GenericResponse.success(adminPlaneSeatService.createPlaneSeat(request), HttpStatus.CREATED);
    }
}
