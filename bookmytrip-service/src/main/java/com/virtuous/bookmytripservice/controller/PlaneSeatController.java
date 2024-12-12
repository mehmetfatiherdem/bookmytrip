package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneSeatPartialUpdateRequest;
import com.virtuous.bookmytripservice.dto.request.PlaneSeatSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneSeatResponse;
import com.virtuous.bookmytripservice.service.PlaneSeatService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plane-seats")
@RequiredArgsConstructor
public class PlaneSeatController {

    private final PlaneSeatService planeSeatService;

    @GetMapping
    public GenericResponse<List<PlaneSeatResponse>> getAllPlaneSeats() {
        return GenericResponse.success(planeSeatService.getAllPlaneSeats(), HttpStatus.OK);
    }

    @GetMapping("/{planeSeatId}")
    public GenericResponse<PlaneSeatResponse> getPlaneSeatById(@PathVariable String planeSeatId) {
        return GenericResponse.success(planeSeatService.getPlaneSeatById(planeSeatId), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<PlaneSeatResponse> createPlaneSeat(@Valid @RequestBody PlaneSeatSaveRequest request) {
        return GenericResponse.success(planeSeatService.createPlaneSeat(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{planeSeatId}")
    public GenericResponse<PlaneSeatResponse> partialUpdatePlaneSeatById(@PathVariable String planeSeatId, @Valid @RequestBody PlaneSeatPartialUpdateRequest request) {
        return GenericResponse.success(planeSeatService.partialUpdatePlaneSeatById(planeSeatId, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{planeSeatId}")
    public GenericResponse<PlaneSeatResponse> updatePlaneSeatById(@PathVariable String planeSeatId, @Valid @RequestBody PlaneSeatSaveRequest request) {
        return GenericResponse.success(planeSeatService.updatePlaneSeatById(planeSeatId, request), HttpStatus.OK);
    }
}
