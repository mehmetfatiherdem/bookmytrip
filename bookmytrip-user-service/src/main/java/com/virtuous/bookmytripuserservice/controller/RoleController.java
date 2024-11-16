package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.RoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public GenericResponse<RoleResponse> createRole(@RequestBody RoleSaveRequest request) {
        return GenericResponse.success(roleService.createRole(request), HttpStatus.CREATED);
    }
}
