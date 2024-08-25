package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.UserRoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
public class UserRoleController {

    private final AdminService adminService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(path = "/add-role-to-user")
    public GenericResponse<UserRoleResponse> addRoleToUser(@RequestBody UserRoleSaveRequest request) {
        return GenericResponse.success(adminService.addRoleToUser(request), HttpStatus.OK);
    }
}
