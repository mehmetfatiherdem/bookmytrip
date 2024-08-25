package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.converter.RoleConverter;
import com.virtuous.bookmytripuserservice.dto.request.RoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.exception.BookMyTripException;
import com.virtuous.bookmytripuserservice.exception.ExceptionMessages;
import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.enums.RoleType;
import com.virtuous.bookmytripuserservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleResponse createRole(RoleSaveRequest request) {
        Role role = new Role();
        role.setName(RoleType.valueOf(request.getName()));

        roleRepository.save(role);

        return RoleConverter.toResponse(role);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role findRoleByRoleType(RoleType roleType) {
        Optional<Role> role = roleRepository.findRoleByName(roleType);

        if (role.isEmpty()) {
            throw new BookMyTripException(ExceptionMessages.ROLE_NOT_FOUND);
        }

        return role.get();
    }
}
