package com.virtuous.bookmytripservice.controller;

import com.virtuous.bookmytripservice.dto.request.PlaneTicketSaveRequest;
import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneResponse;
import com.virtuous.bookmytripservice.dto.response.PlaneTicketResponse;
import com.virtuous.bookmytripservice.service.AdminPlaneTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/admin/tickets/plane-ticket")
@RequiredArgsConstructor
public class AdminPlaneTicketController {

    private final AdminPlaneTicketService adminPlaneTicketService;

    @PostMapping
    public GenericResponse<PlaneTicketResponse> createPlaneTicket(@RequestBody PlaneTicketSaveRequest request) {
        return GenericResponse.success(adminPlaneTicketService.createPlaneTicket(request), HttpStatus.CREATED);
    }
}
