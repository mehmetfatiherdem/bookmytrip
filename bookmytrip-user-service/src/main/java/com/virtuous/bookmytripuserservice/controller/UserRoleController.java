package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.UserRoleRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.service.UserRoleService;
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

    @PostMapping
    public GenericResponse<UserRoleResponse> addRoleToUser(@RequestBody UserRoleRequest request) {
        return GenericResponse.success(userRoleService.addRoleToUser(request), HttpStatus.OK);
    }

    @PostMapping("/remove")
    public GenericResponse<UserRoleResponse> removeRoleFromUser(@RequestBody UserRoleRequest request) {
        return GenericResponse.success(userRoleService.removeRoleFromUser(request), HttpStatus.OK);
    }
}
