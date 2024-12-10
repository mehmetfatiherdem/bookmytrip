package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.converter.RoleConverter;
import com.virtuous.bookmytripuserservice.dto.request.RolePartialUpdateRequest;
import com.virtuous.bookmytripuserservice.dto.request.RoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.exception.BookMyTripException;
import com.virtuous.bookmytripuserservice.exception.ExceptionMessages;
import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.enums.RoleName;
import com.virtuous.bookmytripuserservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleResponse partialUpdateRoleByRoleName(String roleName, RolePartialUpdateRequest request) {
        var role = findRoleByRoleName(RoleName.valueOf(roleName.toUpperCase()));
        if(request.getName().isPresent()) {
            role.setName(RoleName.valueOf(request.getName().get().toUpperCase()));
        }
        roleRepository.save(role);
        return RoleConverter.toResponse(role);
    }

    public RoleResponse updateRoleByRoleName(String roleName, RoleSaveRequest request) {
        var role = findRoleByRoleName(RoleName.valueOf(roleName.toUpperCase()));
        role.setName(RoleName.valueOf(request.getName().toUpperCase()));
        roleRepository.save(role);
        return RoleConverter.toResponse(role);
    }

    public RoleResponse getRoleByRoleName(String roleName) {
        var role = findRoleByRoleName(RoleName.valueOf(roleName.toUpperCase()));
        return RoleConverter.toResponse(role);
    }

    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return RoleConverter.toResponse(roles);
    }

    public RoleResponse createRole(RoleSaveRequest request) {
        Role role = new Role();
        role.setName(RoleName.valueOf(request.getName().toUpperCase()));

        roleRepository.save(role);

        return RoleConverter.toResponse(role);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role findRoleByRoleName(RoleName roleName) {
        Optional<Role> role = roleRepository.findRoleByName(roleName);

        if (role.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.ROLE_NOT_FOUND);
        }

        return role.get();
    }
}
