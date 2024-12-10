package com.virtuous.bookmytripuserservice.controller;

import com.virtuous.bookmytripuserservice.dto.request.RolePartialUpdateRequest;
import com.virtuous.bookmytripuserservice.dto.request.RoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @SecurityRequirement(name = "Authorization")
    @GetMapping
    public GenericResponse<List<RoleResponse>> getRoles() {
        return GenericResponse.success(roleService.getAllRoles(), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @GetMapping("/{roleName}")
    public GenericResponse<RoleResponse> getRoleByRoleName(@PathVariable String roleName) {
        return GenericResponse.success(roleService.getRoleByRoleName(roleName), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PostMapping
    public GenericResponse<RoleResponse> createRole(@Valid @RequestBody RoleSaveRequest request) {
        return GenericResponse.success(roleService.createRole(request), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Authorization")
    @PatchMapping("/{roleName}")
    public GenericResponse<RoleResponse> partialUpdateRoleByRoleName(@PathVariable String roleName, @Valid @RequestBody RolePartialUpdateRequest request) {
        return GenericResponse.success(roleService.partialUpdateRoleByRoleName(roleName, request), HttpStatus.OK);
    }

    @SecurityRequirement(name = "Authorization")
    @PutMapping("/{roleName}")
    public GenericResponse<RoleResponse> updateRoleByRoleName(@PathVariable String roleName, @Valid @RequestBody RoleSaveRequest request) {
        return GenericResponse.success(roleService.updateRoleByRoleName(roleName, request), HttpStatus.OK);
    }
}
