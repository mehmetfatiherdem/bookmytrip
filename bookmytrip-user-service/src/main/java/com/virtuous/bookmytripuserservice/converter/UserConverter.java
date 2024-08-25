package com.virtuous.bookmytripuserservice.converter;

import com.virtuous.bookmytripuserservice.dto.response.UserResponse;
import com.virtuous.bookmytripuserservice.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .bio(user.getBio())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static List<UserResponse> toResponse(List<User> users) {
        return users
                .stream()
                .map(UserConverter::toResponse)
                .toList();
    }
}
