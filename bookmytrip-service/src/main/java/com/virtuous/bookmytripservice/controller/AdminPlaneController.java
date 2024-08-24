package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.service.AdminPlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/tickets/plane")
@RequiredArgsConstructor
public class AdminPlaneController {

    private final AdminPlaneService adminPlaneService;

    @PostMapping
    public GenericResponse<PlaneResponse> createPlane(@RequestBody PlaneSaveRequest request) {
        return GenericResponse.success(adminPlaneService.createPlane(request), HttpStatus.CREATED);
    }
}
