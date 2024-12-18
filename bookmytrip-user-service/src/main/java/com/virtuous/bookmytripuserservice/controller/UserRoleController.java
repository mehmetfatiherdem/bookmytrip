package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.UserRoleRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.service.UserRoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;
    @SecurityRequirement(name = "Authorization")

    @PostMapping
    public GenericResponse<UserRoleResponse> addRoleToUser(@Valid @RequestBody UserRoleRequest request) {
        return GenericResponse.success(userRoleService.addRoleToUser(request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping("/remove")
    public GenericResponse<UserRoleResponse> removeRoleFromUser(@Valid @RequestBody UserRoleRequest request) {
        return GenericResponse.success(userRoleService.removeRoleFromUser(request), HttpStatus.OK);
    }
}
