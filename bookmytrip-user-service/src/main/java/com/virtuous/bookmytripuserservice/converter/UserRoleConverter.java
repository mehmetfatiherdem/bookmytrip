package com.virtuous.bookmytripuserservice.converter;

import com.virtuous.bookmytripuserservice.dto.response.UserRoleResponse;
import com.virtuous.bookmytripuserservice.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRoleConverter {

    public static UserRoleResponse toResponse(User user) {

        return UserRoleResponse.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roles(RoleConverter.toResponse(user.getRoles().stream().toList()))
                .build();
    }

}
