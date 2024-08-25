package com.virtuous.bookmytripuserservice.converter;

import com.virtuous.bookmytripuserservice.dto.response.RoleResponse;
import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRoleConverter {

    public static UserRoleResponse toResponse(User user) {

        return UserRoleResponse.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roles( user.getRoles()
                        .stream()
                        .map(role -> new RoleResponse(role.getName().name()))
                        .collect(Collectors.toSet()))
                .build();
    }

}
