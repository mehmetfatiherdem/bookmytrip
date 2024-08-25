package com.virtuous.bookmytripuserservice.converter;

import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.model.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleConverter {

    public static RoleResponse toResponse(Role role) {
        return RoleResponse.builder()
                .name(role.getName().name())
                .build();
    }

    public static List<RoleResponse> toResponse(List<Role> roles) {
        return roles
                .stream()
                .map(RoleConverter::toResponse)
                .toList();
    }
}
