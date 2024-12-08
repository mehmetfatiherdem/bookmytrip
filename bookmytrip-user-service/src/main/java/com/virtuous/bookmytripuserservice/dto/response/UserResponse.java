package com.virtuous.bookmytripuserservice.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String bio;
    private String phoneNumber;
    private List<RoleResponse> userRoles;
}
