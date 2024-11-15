package com.virtuous.bookmytripuserservice.service;

import com.virtuous.bookmytripuserservice.converter.UserRoleConverter;
import com.virtuous.bookmytripuserservice.dto.request.UserRoleSaveRequest;
import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.model.Role;
import com.virtuous.bookmytripuserservice.model.User;
import com.virtuous.bookmytripuserservice.model.enums.RoleName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final RoleService roleService;
    private final UserService userService;

    public UserRoleResponse addRoleToUser(UserRoleSaveRequest request) {

        User user = userService.findByEmail(request.getEmail());
        Role role = roleService.findRoleByRoleType(RoleName.valueOf(request.getRoleName()));

        user.getRoles().add(role);
        role.getUsers().add(user);

        User updatedUser = userService.save(user);
        roleService.save(role);

        return UserRoleConverter.toResponse(updatedUser);

    }

}
